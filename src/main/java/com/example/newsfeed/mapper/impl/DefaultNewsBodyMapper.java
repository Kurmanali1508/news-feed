package com.example.newsfeed.mapper.impl;

import com.example.newsfeed.dto.NewsBodyDto;
import com.example.newsfeed.entity.NewsBody;
import com.example.newsfeed.mapper.NewsBodyMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultNewsBodyMapper implements NewsBodyMapper {
    @Override
    public NewsBodyDto toNewsBodyDto(NewsBody newsBody) {
        NewsBodyDto newsBodyDto = new NewsBodyDto();

        newsBodyDto.setId(newsBody.getId());
        newsBodyDto.setFileName(newsBody.getFileName());
        newsBodyDto.setSize(newsBody.getSize());
        newsBodyDto.setFileDownloadUri(newsBody.getFileDownloadUri());
        newsBodyDto.setFileType(newsBody.getFileType());

        return newsBodyDto;
    }
}