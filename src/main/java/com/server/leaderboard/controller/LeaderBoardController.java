package com.server.leaderboard.controller;

import com.server.leaderboard.controller.dto.PlayerScoreDTO;
import com.server.leaderboard.gateway.LeaderBoardTimeType;
import com.server.leaderboard.service.ScoreStoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
@AllArgsConstructor
public class LeaderBoardController {

    private final ScoreStoreService sc;
    @GetMapping("/current")
    public ResponseEntity<List<PlayerScoreDTO>> getLeaderBoard(@RequestParam("quizId") String quizId, @RequestParam("topN") Integer topN) {
        List<PlayerScoreDTO> topPlayers = sc.getTopPlayers(quizId, topN);
        return ResponseEntity.ok(topPlayers);
    }
}
