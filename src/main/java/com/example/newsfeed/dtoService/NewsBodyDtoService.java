package com.example.newsfeed.dtoService;

import com.example.newsfeed.entity.NewsBody;
import org.springframework.web.multipart.MultipartFile;

public interface NewsBodyDtoService {
    NewsBody create(MultipartFile multipartFile);
}