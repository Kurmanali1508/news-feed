package com.example.newsfeed.mapper.impl;

import com.example.newsfeed.dto.ImageDto;
import com.example.newsfeed.entity.Image;
import com.example.newsfeed.mapper.ImageMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultImageMapper implements ImageMapper {
    @Override
    public ImageDto toImageDto(Image image) {
        ImageDto imageDto = new ImageDto();

        imageDto.setId(image.getId());
        imageDto.setImageName(image.getImageName());
        imageDto.setSize(image.getSize());
        imageDto.setFileDownloadUri(image.getFileDownloadUri());
        imageDto.setFileType(image.getFileType());

        return imageDto;
    }
}