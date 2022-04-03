package com.example.newsfeed.mapper;

import com.example.newsfeed.dto.ImageDto;
import com.example.newsfeed.entity.Image;

public interface ImageMapper {
    ImageDto toImageDto(Image image);
}