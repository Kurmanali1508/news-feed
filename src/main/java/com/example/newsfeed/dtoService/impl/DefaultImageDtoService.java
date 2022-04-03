package com.example.newsfeed.dtoService.impl;

import com.example.newsfeed.dtoService.BaseFileDtoService;
import com.example.newsfeed.dtoService.ImageDtoService;
import com.example.newsfeed.entity.Image;
import com.example.newsfeed.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Service
public class DefaultImageDtoService implements ImageDtoService {
    private final ImageService imageService;
    private final BaseFileDtoService baseFileDtoService;

    @Autowired
    public DefaultImageDtoService(ImageService imageService, BaseFileDtoService baseFileDtoService) {
        this.imageService = imageService;
        this.baseFileDtoService = baseFileDtoService;
    }

    @Override
    public Image getById(Long id) {
        return imageService.getById(id);
    }

    @Override
    public List<Image> getAll() {
        return imageService.getAll();
    }

    @Override
    public Image create(MultipartFile multipartFile) {
        Image image = new Image();

        String fileName = baseFileDtoService.storeFile(multipartFile);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/v1/download/")
                .path(fileName)
                .toUriString();

        image.setImageName(multipartFile.getOriginalFilename());
        image.setFileDownloadUri(fileDownloadUri);
        image.setFileType(multipartFile.getContentType());
        image.setSize(multipartFile.getSize());

        return imageService.save(image);
    }
}