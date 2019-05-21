package com.codecool.funfactservice.controller;

import com.codecool.funfactservice.model.FunFactModel;
import com.codecool.funfactservice.service.FunFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunFactController {

    @Autowired
    private FunFactService funFactService;

    @GetMapping("/random-fact")
    public FunFactModel getRandomFact() {
        return funFactService.getRandomFunFact();
    }

}
