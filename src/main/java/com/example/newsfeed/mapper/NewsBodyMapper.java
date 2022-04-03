package com.example.newsfeed.mapper;

import com.example.newsfeed.dto.NewsBodyDto;
import com.example.newsfeed.entity.NewsBody;

public interface NewsBodyMapper {
    NewsBodyDto toNewsBodyDto(NewsBody newsBody);
}