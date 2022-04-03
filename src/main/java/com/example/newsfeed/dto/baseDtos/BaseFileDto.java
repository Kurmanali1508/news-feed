package com.example.newsfeed.dto.baseDtos;

import lombok.Data;

@Data
public class BaseFileDto {
    private Long id;
    private String fileType;
    private Long size;
    private String fileDownloadUri;
}