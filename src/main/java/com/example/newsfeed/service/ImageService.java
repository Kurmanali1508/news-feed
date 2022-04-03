package com.example.newsfeed.service;

import com.example.newsfeed.entity.Image;

import java.util.List;

public interface ImageService {
    Image getById(Long id);
    List<Image> getAll();
    Image save(Image image);
}