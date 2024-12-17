package com.server.leaderboard.service;

import com.server.leaderboard.controller.dto.PlayerScoreDTO;
import com.server.leaderboard.controller.params.ScoreRequestBody;
import com.server.leaderboard.gateway.LeaderBoardTimeType;
import com.server.leaderboard.gateway.ScoreStoreGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
@AllArgsConstructor
public class ScoreStoreServiceImpl implements ScoreStoreService {

    private final ScoreStoreGateway scoreStoreGateway;
    @Override
    public boolean addScore(ScoreRequestBody body) {
        return scoreStoreGateway.addScore(body.getQuizId(), body.getPlayerUsername(), body.getScore().longValue(), body.getTimestamp());
    }


    @Override
    public List<PlayerScoreDTO> getTopPlayers(String quizId, Integer topN) {
        Map<String, Double> currentToplayersWithScore =
                scoreStoreGateway.getCurrentToplayersWithScore(quizId, topN);

        return currentToplayersWithScore.entrySet().stream()
                .map(entry -> new PlayerScoreDTO(entry.getKey(), entry.getValue()))
                .sorted((p1, p2) -> Double.compare(p2.getScore(), p1.getScore()))
                .toList();
    }
}
