package com.example.newsfeed.exceptions;

public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException(String message) {
        super(message);
    }
}