package com.codecool.comicservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Random;
import java.util.ResourceBundle;

@Service
@Data
public class ComicService {

    @Value("${comic-api.url}")
    private String apiLink;

    Random random = new Random();

    @Autowired
    RestTemplate restTemplate;

    public String getComic() throws IOException {
        String url = apiLink + "/" + random.nextInt(1930) + "/info.0.json";
        System.out.println(url);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        System.out.println(root.path("img").asText());
        return root.path("img").asText();

    }



}
