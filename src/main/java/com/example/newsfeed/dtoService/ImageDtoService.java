package com.example.newsfeed.dtoService;

import com.example.newsfeed.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageDtoService {
    Image getById(Long id);
    List<Image> getAll();
    Image create(MultipartFile multipartFile);
}