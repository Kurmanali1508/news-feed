package com.example.newsfeed.dtoService;

import com.example.newsfeed.dto.NewsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsDtoService {
    NewsDto getById(Long id);
    List<NewsDto> getAll();
    void delete(Long id);
    NewsDto create(String title, MultipartFile image, MultipartFile textFile);
    Page<NewsDto> getAllPage(Pageable pageable);
}