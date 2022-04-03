package com.example.newsfeed.exceptions;

public class FileIsNotTextFormat extends RuntimeException{
    public FileIsNotTextFormat(String message) {
        super(message);
    }
}