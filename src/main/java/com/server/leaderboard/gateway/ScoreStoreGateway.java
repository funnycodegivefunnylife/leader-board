package com.server.leaderboard.gateway;

import jakarta.validation.constraints.NotNull;

import java.util.Map;

public interface ScoreStoreGateway {

    Map<String, Double> getCurrentToplayersWithScore(String quizId, Integer topN);

    boolean addScore(String quizId, String playerUsername, long l, Long timestamp);
}
