package com.codecool.funfactservice.service;

import com.codecool.funfactservice.model.FunFactModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class FunFactService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    FunFactModel funFactModel;

    @Value("${funfact.url}")
    public String funFactUrl;

    public ResponseEntity<FunFactModel> getRandomFunFact(){
        System.out.println(funFactUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        ResponseEntity<FunFactModel> funFactResult = restTemplate.exchange(funFactUrl, HttpMethod.GET, entity, FunFactModel.class);
        System.out.println(funFactResult);
        return funFactResult;
    }

}
