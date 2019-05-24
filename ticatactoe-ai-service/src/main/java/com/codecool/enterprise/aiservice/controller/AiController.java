package com.codecool.enterprise.aiservice.controller;

import com.codecool.enterprise.aiservice.model.AiResponseModel;
import com.codecool.enterprise.aiservice.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AiController {

    @Autowired
    private AiService aiService;

        @GetMapping("/get-response/{game-state}")
    public AiResponseModel getResponse(@RequestParam("game-state")String gameState) throws IOException {
        return aiService.getAiMove(gameState);
    }
}
