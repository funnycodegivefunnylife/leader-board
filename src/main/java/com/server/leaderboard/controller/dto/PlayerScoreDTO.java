package com.server.leaderboard.controller.dto;

import lombok.Data;

@Data
public class PlayerScoreDTO {
    private String playerUsername;
    private Double score;

    public PlayerScoreDTO(String playerUsername, Double score) {
        this.playerUsername = playerUsername;
        this.score = score;
    }

    public String getPlayerUsername() {
        return playerUsername;
    }

    public Double getScore() {
        return score;
    }
}
