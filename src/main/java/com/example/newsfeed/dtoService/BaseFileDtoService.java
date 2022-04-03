package com.example.newsfeed.dtoService;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface BaseFileDtoService {
    String storeFile(MultipartFile multipartFile);
    Resource loadFileAsResource(String fileName);
}