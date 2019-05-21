package com.codecool.funfactservice.service;

import com.codecool.funfactservice.model.FunFactModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunFactService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${funfact.url}")
    public String funFactUrl;

    public FunFactModel getRandomFunFact(){
        System.out.println(funFactUrl);
        FunFactModel funFactResult = restTemplate.getForObject(funFactUrl, FunFactModel.class);
        String funFact = funFactResult.value;
        System.out.println(funFact + "IDENÉZZTGEGEFADWMAKSDASÉD");
        return funFactResult;
    }

}
