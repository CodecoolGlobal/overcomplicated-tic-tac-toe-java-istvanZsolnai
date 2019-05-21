package com.codecool.funfactservice.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunFactService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${funfact.url}")
    public String funFactUrl;

    public String getRandomFunFact(){

        String funFactResult = restTemplate.getForObject(funFactUrl, String.class);
        System.out.println(funFactResult);
        return funFactResult;
    }

}
