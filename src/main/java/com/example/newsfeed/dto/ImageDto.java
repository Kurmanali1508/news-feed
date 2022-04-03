package com.example.newsfeed.dto;

import com.example.newsfeed.dto.baseDtos.BaseFileDto;
import lombok.Data;

@Data
public class ImageDto extends BaseFileDto {
    private String imageName;
}