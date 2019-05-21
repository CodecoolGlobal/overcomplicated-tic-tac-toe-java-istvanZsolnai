package com.codecool.funfactservice.controller;

import com.codecool.funfactservice.service.FunFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunFactController {

    @Autowired
    private FunFactService funFactService;

    @GetMapping("/random-fact")
    public String getRandomFact() {
        String randomFact = funFactService.getRandomFunFact();
        System.out.println(randomFact);
        return randomFact;
    }

}
