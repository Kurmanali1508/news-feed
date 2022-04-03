package com.example.newsfeed.service.impl;

import com.example.newsfeed.entity.NewsBody;
import com.example.newsfeed.repository.NewsBodyRepository;
import com.example.newsfeed.service.NewsBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultNewsBodyService implements NewsBodyService {
    private final NewsBodyRepository newsBodyRepository;

    @Autowired
    public DefaultNewsBodyService(NewsBodyRepository newsBodyRepository) {
        this.newsBodyRepository = newsBodyRepository;
    }

    @Override
    public NewsBody save(NewsBody newsBody) {
        return newsBodyRepository.save(newsBody);
    }
}