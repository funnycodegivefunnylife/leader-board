package com.server.leaderboard.gateway;

public enum LeaderBoardTimeType {
    DAY(0),
    WEEK(1),
    MONTH(2);

    private final int value;

    LeaderBoardTimeType(int value) {
        this.value = value;
    }
}
