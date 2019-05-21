package com.codecool.enterprise.overcomplicated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ServiceCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${chuck-norris.url}")
    private String funFact;

}

