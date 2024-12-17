package com.server.leaderboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/leaderboard")
    public String showLeaderboardPage() {
        return "leaderboard.html"; // Return the name of the HTML file without the extension
    }
}
