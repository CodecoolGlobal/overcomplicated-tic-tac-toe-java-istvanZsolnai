package com.codecool.comicservice.controller;

import com.codecool.comicservice.service.ComicService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ComicController {

    @Autowired
    private ComicService service;

    @GetMapping("/getcomic")
    public String getRandomComic() throws IOException {
        return service.getComic();
    }

}
