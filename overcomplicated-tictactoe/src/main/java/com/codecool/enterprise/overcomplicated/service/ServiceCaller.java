package com.codecool.enterprise.overcomplicated.service;

import com.codecool.enterprise.overcomplicated.model.FunFact;
import com.codecool.enterprise.overcomplicated.model.Recommendation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@Data
public class ServiceCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${chuck-norris.url}")
    private String funFact;

    @Value("${comic.url}")
    private String comicService;

    @Value("${avatar.url}")
    private String avatarURL;

    @Value("${ai-move.url}")
    private String aiMove;


    public URL getAvatar() throws MalformedURLException {
       // String test = getData(avatarURL);
        //System.out.println(test);

        return new URL(getData(avatarURL));
    }

    public int retrieveRecommendation(String gameState, String player) throws IOException {
        String aiApi = aiMove + "/" + gameState + "/" + player;
        System.out.println(aiApi);
        ObjectMapper objectMapper = new ObjectMapper();
        String recommendation = getData(aiApi);
        Recommendation aiMove = new Recommendation();

        Recommendation aiRecommendation = objectMapper.readValue(recommendation, Recommendation.class);
        aiMove.setRecommendation(aiRecommendation.getRecommendation());
        int aiMoveInt = Integer.parseInt(aiMove.getRecommendation());
        return aiMoveInt;

    }


    public String retrieveComic(){

        return getData(comicService);
    }

    public FunFact retrieveFunFact() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String funFactoid = getData(funFact);
        FunFact funFactModel = new FunFact();
        FunFact fact = objectMapper.readValue(funFactoid, FunFact.class);
        System.out.println(fact.getValue());
        funFactModel.setValue(fact.getValue());
        return funFactModel;
    }

    private String getData(String URI){
        URL url;
        HttpURLConnection connection;
        BufferedReader reader;
        String response = "";

        try{
            url = new URL(URI);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozila/5.0");

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = reader.readLine();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;


    }

}
