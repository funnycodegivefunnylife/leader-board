package com.server.leaderboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LeaderBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaderBoardApplication.class, args);
    }

}
