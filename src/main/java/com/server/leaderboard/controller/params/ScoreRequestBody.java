package com.server.leaderboard.controller.params;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ScoreRequestBody {

    @NotNull
    private String playerUsername;

    @NotNull
    private Integer score;

    @NotNull
    private Long timestamp;

    @NotNull
    private String quizId;
}
