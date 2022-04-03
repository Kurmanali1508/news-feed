package com.example.newsfeed.mapper.impl;

import com.example.newsfeed.dto.NewsDto;
import com.example.newsfeed.entity.News;
import com.example.newsfeed.mapper.ImageMapper;
import com.example.newsfeed.mapper.NewsBodyMapper;
import com.example.newsfeed.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultNewsMapper implements NewsMapper {
    private final ImageMapper imageMapper;
    private final NewsBodyMapper newsBodyMapper;

    @Autowired
    public DefaultNewsMapper(ImageMapper imageMapper, NewsBodyMapper newsBodyMapper) {
        this.imageMapper = imageMapper;
        this.newsBodyMapper = newsBodyMapper;
    }

    @Override
    public NewsDto toNewsDto(News news) {
        NewsDto newsDto = new NewsDto();

        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setPublicationDate(news.getPublicationDate());

        if (news.getImage() != null) {
            newsDto.setImageDto(imageMapper.toImageDto(news.getImage()));
        }

        if (news.getNewsBody() != null) {
            newsDto.setNewsBodyDto(newsBodyMapper.toNewsBodyDto(news.getNewsBody()));
        }

        return newsDto;
    }
}