package com.codecool.enterprise.aiservice.service;

import com.codecool.enterprise.aiservice.model.AiResponseModel;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class AiService {

    @Value("${api.url}")
    private String apiURL;

    public AiResponseModel getAiMove(String gameState) throws IOException {
        URL url = new URL(apiURL + gameState);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseString = in.readLine();

        Gson gson = new Gson();
        AiResponseModel responseModel = gson.fromJson(responseString, AiResponseModel.class);

        return responseModel;

    }
}
