package com.example.newsfeed.service;

import com.example.newsfeed.entity.News;

import java.util.List;

public interface NewsService {
    News getById(Long id);
    List<News> getAll();
    News save(News news);
}