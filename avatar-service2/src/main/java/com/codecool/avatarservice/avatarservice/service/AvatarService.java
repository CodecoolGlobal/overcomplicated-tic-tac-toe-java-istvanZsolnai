package com.codecool.avatarservice.avatarservice.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

@Service
@Data
public class AvatarService {

    @Autowired
    private AvatarService avatarService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${avatar.url}")
    private String avatarApi;

    Random random = new Random();

    public URL getAvatar() throws MalformedURLException {
        String avatar = avatarApi + "/" + random.nextInt(1000);
        return new URL(avatar);
    }
}
