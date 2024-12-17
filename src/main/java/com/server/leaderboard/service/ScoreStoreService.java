package com.server.leaderboard.service;

import com.server.leaderboard.controller.dto.PlayerScoreDTO;
import com.server.leaderboard.controller.params.ScoreRequestBody;
import com.server.leaderboard.gateway.LeaderBoardTimeType;

import java.util.List;

public interface ScoreStoreService {
    boolean addScore(ScoreRequestBody body);

    List<PlayerScoreDTO> getTopPlayers(String quizId, Integer topN);
}
