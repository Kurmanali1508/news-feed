package com.example.newsfeed.dtoService.impl;

import com.example.newsfeed.config.FileStorageConfig;
import com.example.newsfeed.dtoService.BaseFileDtoService;
import com.example.newsfeed.exceptions.FileNotFoundException;
import com.example.newsfeed.exceptions.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class DefaultBaseFileDtoService implements BaseFileDtoService {
    private final Path fileStorageLocation;

    @Autowired
    public DefaultBaseFileDtoService(FileStorageConfig fileStorageConfig) {
        this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception exception) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored!");
        }
    }

    @Override
    public String storeFile(MultipartFile multipartFile) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException exception) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();

            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }
}