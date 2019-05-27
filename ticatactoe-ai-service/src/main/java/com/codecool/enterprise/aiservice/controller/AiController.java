package com.codecool.enterprise.aiservice.controller;

import com.codecool.enterprise.aiservice.model.AiResponseModel;
import com.codecool.enterprise.aiservice.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AiController {

    @Autowired
    private AiService aiService;

        @GetMapping("/get-response/{game-state}/{player}")
    public ResponseEntity<AiResponseModel> getResponse(@PathVariable("game-state")String gameState,
                                                        @PathVariable("player")String player) throws IOException {
            System.out.println(gameState);
            System.out.println(player);

        return aiService.getAiMove(gameState,player);
    }
}
