package com.codecool.enterprise.aiservice.service;

import com.codecool.enterprise.aiservice.model.AiResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Service
public class AiService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiURL;

    public ResponseEntity<AiResponseModel> getAiMove(String gameState, String player) throws IOException {

        String aiApi = apiURL + gameState + "/" + player;
        System.out.println(aiApi + "        asdasdasdasd");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Moilla/5.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<AiResponseModel> aiMove = restTemplate.exchange(aiApi, HttpMethod.GET,
                entity, AiResponseModel.class);

        System.out.println( "HEREERERE" +aiMove);
        return aiMove;


        /*
        URL url = new URL(apiURL + gameState);
        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseString = in.readLine();

        Gson gson = new Gson();
        AiResponseModel responseModel = gson.fromJson(responseString, AiResponseModel.class);

        return responseModel;*/

    }
}
