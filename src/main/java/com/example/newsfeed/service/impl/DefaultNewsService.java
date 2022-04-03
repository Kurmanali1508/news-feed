package com.example.newsfeed.service.impl;

import com.example.newsfeed.entity.News;
import com.example.newsfeed.repository.NewsRepository;
import com.example.newsfeed.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultNewsService implements NewsService {
    private final NewsRepository newsRepository;

    public DefaultNewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News getById(Long id) {
        return newsRepository.findByIdAndIsDeletedIsFalse(id);
    }

    @Override
    public List<News> getAll() {
        return newsRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public Page<News> getAllPage(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }
}