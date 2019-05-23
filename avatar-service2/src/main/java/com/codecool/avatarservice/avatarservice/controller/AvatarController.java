package com.codecool.avatarservice.avatarservice.controller;

import com.codecool.avatarservice.avatarservice.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/get-avatar")
    public URL getRandomAvatar() throws MalformedURLException {
        return avatarService.getAvatar();
    }


}
