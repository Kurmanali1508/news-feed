package com.example.newsfeed.service;

import com.example.newsfeed.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    News getById(Long id);
    List<News> getAll();
    News save(News news);
    Page<News> getAllPage(Pageable pageable);
}