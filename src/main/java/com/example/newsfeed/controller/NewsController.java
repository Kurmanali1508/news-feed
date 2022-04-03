package com.example.newsfeed.controller;

import com.example.newsfeed.dto.NewsDto;
import com.example.newsfeed.dtoService.NewsDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1")
public class NewsController {
    private final NewsDtoService newsDtoService;

    @Autowired
    public NewsController(NewsDtoService newsDtoService) {
        this.newsDtoService = newsDtoService;
    }

    @PostMapping
    public NewsDto create(@RequestParam("title") String title,
                          @RequestParam("image") MultipartFile image,
                          @RequestParam("textFile") MultipartFile textFile) {

        return newsDtoService.create(title, image, textFile);
    }
}