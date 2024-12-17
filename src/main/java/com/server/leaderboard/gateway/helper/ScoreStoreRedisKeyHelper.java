package com.server.leaderboard.gateway.helper;

import com.server.leaderboard.gateway.LeaderBoardTimeType;
import com.server.leaderboard.shared.TimeUtil;

public class ScoreStoreRedisKeyHelper {

    private ScoreStoreRedisKeyHelper() {
    }

    public static String getLeaderboardKeyByWeekBaseOnTimestamp(Long timestamp) {
        Long startOfWeekTimestamp = TimeUtil.getStartOfWeekTimestamp(timestamp);
        Long endOfWeekTimestamp = TimeUtil.getEndOfWeekTimestamp(timestamp);
        return "leaderboard-week-" + startOfWeekTimestamp + "-" + endOfWeekTimestamp;
    }

    public static String getLeaderboardKeyByMonthBaseOnTimestamp(Long timestamp) {
        Long startOfMonthTimestamp = TimeUtil.getStartOfMonthTimestamp(timestamp);
        Long endOfMonthTimestamp = TimeUtil.getEndOfMonthTimestamp(timestamp);
        return "leaderboard-month-" + startOfMonthTimestamp + "-" + endOfMonthTimestamp;
    }

    public static String getLeaderboardKeyByDayBaseOnTimestamp(Long timestamp) {
        Long startOfDayTimestamp = TimeUtil.getStartOfDayTimestamp(timestamp);
        Long endOfDayTimestamp = TimeUtil.getEndOfDayTimestamp(timestamp);
        return "leaderboard-day-" + startOfDayTimestamp + "-" + endOfDayTimestamp;
    }

    public static String getLeaderboardKeyBaseOnTimeType(Long timestamp, LeaderBoardTimeType timeType) {
        switch (timeType) {
            case WEEK:
                return getLeaderboardKeyByWeekBaseOnTimestamp(timestamp);
            case MONTH:
                return getLeaderboardKeyByMonthBaseOnTimestamp(timestamp);
            case DAY:
                return getLeaderboardKeyByDayBaseOnTimestamp(timestamp);
            default:
                break;
        }

        return "";
    }

    public static String getLeaderboardKeyBaseOnQuizId(String quizId) {
        return "leaderboard-quiz-" + quizId;
    }
}
