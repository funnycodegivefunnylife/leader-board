package com.server.leaderboard.controller;

import com.server.leaderboard.controller.params.ScoreRequestBody;
import com.server.leaderboard.service.ScoreStoreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
@AllArgsConstructor
public class ScoreInputController {
    private final ScoreStoreService scoreStoreService;

    @PostMapping("")
    public ResponseEntity<String> addScore(@RequestBody @Valid ScoreRequestBody body) {
        boolean result = scoreStoreService.addScore(body);
        return ResponseEntity.ok(result ? "Score was recorded" : "Failed to record score");
    }
}
