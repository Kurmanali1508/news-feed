package com.example.newsfeed.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NewsDto {
    private Long id;
    private String title;
    private Date publicationDate;
    private ImageDto imageDto;
    private NewsBodyDto newsBodyDto;
}