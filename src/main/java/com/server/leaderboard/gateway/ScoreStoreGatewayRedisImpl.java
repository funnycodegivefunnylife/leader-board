package com.server.leaderboard.gateway;

import com.server.leaderboard.gateway.helper.ScoreStoreRedisKeyHelper;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class ScoreStoreGatewayRedisImpl implements ScoreStoreGateway {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public Map<String, Double> getCurrentToplayersWithScore(String quizId, Integer topN) {
        String key = ScoreStoreRedisKeyHelper.getLeaderboardKeyBaseOnQuizId(quizId);
        Set<ZSetOperations.TypedTuple<String>> resultSet = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, topN - 1);

        Map<String, Double> topPlayersWithScores = new HashMap<>();
        if (resultSet != null) {
            for (ZSetOperations.TypedTuple<String> entry : resultSet) {
                if (entry.getValue() != null && entry.getScore() != null) {
                    topPlayersWithScores.put(entry.getValue(), entry.getScore());
                }
            }
        }
        return topPlayersWithScores;
    }

    @Override
    public boolean addScore(String quizId, String playerUsername, long score, Long timestamp) {
        String key = ScoreStoreRedisKeyHelper.getLeaderboardKeyBaseOnQuizId(quizId);
        Double result = redisTemplate.opsForZSet().incrementScore(key, playerUsername, score);
        return result != null;
    }
}
