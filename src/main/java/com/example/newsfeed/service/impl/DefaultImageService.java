package com.example.newsfeed.service.impl;

import com.example.newsfeed.entity.Image;
import com.example.newsfeed.repository.ImageRepository;
import com.example.newsfeed.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultImageService implements ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public DefaultImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image getById(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Image with id " + id + " is not found!"));
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }
}