package com.example.newsfeed.mapper;

import com.example.newsfeed.dto.NewsDto;
import com.example.newsfeed.entity.News;

public interface NewsMapper {
    NewsDto toNewsDto(News news);
}