package com.example.newsfeed.dtoService.impl;

import com.example.newsfeed.dto.NewsDto;
import com.example.newsfeed.dtoService.ImageDtoService;
import com.example.newsfeed.dtoService.NewsBodyDtoService;
import com.example.newsfeed.dtoService.NewsDtoService;
import com.example.newsfeed.entity.News;
import com.example.newsfeed.mapper.NewsMapper;
import com.example.newsfeed.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultNewsDtoService implements NewsDtoService {
    private final NewsService newsService;
    private final NewsMapper newsMapper;
    private final ImageDtoService imageDtoService;
    private final NewsBodyDtoService newsBodyDtoService;

    @Autowired
    public DefaultNewsDtoService(NewsService newsService, NewsMapper newsMapper, ImageDtoService imageDtoService, NewsBodyDtoService newsBodyDtoService) {
        this.newsService = newsService;
        this.newsMapper = newsMapper;
        this.imageDtoService = imageDtoService;
        this.newsBodyDtoService = newsBodyDtoService;
    }

    @Override
    public NewsDto getById(Long id) {
        return newsMapper.toNewsDto(newsService.getById(id));
    }

    @Override
    public List<NewsDto> getAll() {
        return newsService.getAll()
                .stream()
                .map(newsMapper::toNewsDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        News news = newsService.getById(id);

        news.setDeleted(true);

        newsService.save(news);
    }

    @Override
    public NewsDto create(String title, MultipartFile image, MultipartFile textFile) {
        News news = new News();

        news.setTitle(title);
        news.setPublicationDate(new Date());
        news.setImage(imageDtoService.create(image));
        news.setNewsBody(newsBodyDtoService.create(textFile));

        return newsMapper.toNewsDto(newsService.save(news));
    }

    @Override
    public Page<NewsDto> getAllPage(Pageable pageable) {
       List<NewsDto> news = newsService.getAllPage(pageable)
               .stream()
               .map(newsMapper::toNewsDto)
               .collect(Collectors.toList());

       Page<NewsDto> newsPage = new PageImpl<>(news);

       return newsPage;
    }
}