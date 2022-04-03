package com.example.newsfeed.dtoService.impl;

import com.example.newsfeed.dtoService.BaseFileDtoService;
import com.example.newsfeed.dtoService.NewsBodyDtoService;
import com.example.newsfeed.entity.NewsBody;
import com.example.newsfeed.exceptions.FileIsNotTextFormat;
import com.example.newsfeed.service.NewsBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class DefaultNewsBodyDtoService implements NewsBodyDtoService {
    private final NewsBodyService newsBodyService;
    private final BaseFileDtoService baseFileDtoService;

    @Autowired
    public DefaultNewsBodyDtoService(NewsBodyService newsBodyService, BaseFileDtoService baseFileDtoService) {
        this.newsBodyService = newsBodyService;
        this.baseFileDtoService = baseFileDtoService;
    }

    @Override
    public NewsBody create(MultipartFile multipartFile) {
        NewsBody newsBody = new NewsBody();

        String fileName = baseFileDtoService.storeFile(multipartFile);

        if (fileName.endsWith("text")) {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("api/v1/download/")
                    .path(fileName)
                    .toUriString();

            newsBody.setFileName(multipartFile.getOriginalFilename());
            newsBody.setFileDownloadUri(fileDownloadUri);
            newsBody.setFileType(multipartFile.getContentType());
            newsBody.setSize(multipartFile.getSize());

            return newsBodyService.save(newsBody);
        } else {
            throw new FileIsNotTextFormat("NewsBody is not a text format!");
        }
    }
}