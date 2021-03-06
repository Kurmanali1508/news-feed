package com.example.newsfeed.controller;

import com.example.newsfeed.dto.NewsDto;
import com.example.newsfeed.dtoService.NewsDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public Page<NewsDto> getAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return newsDtoService.getAllPage(pageable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        newsDtoService.delete(id);
    }
}