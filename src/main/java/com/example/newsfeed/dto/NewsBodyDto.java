package com.example.newsfeed.dto;

import com.example.newsfeed.dto.baseDtos.BaseFileDto;
import lombok.Data;

@Data
public class NewsBodyDto extends BaseFileDto {
    private String fileName;
}