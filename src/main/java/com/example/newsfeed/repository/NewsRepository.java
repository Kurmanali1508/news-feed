package com.example.newsfeed.repository;

import com.example.newsfeed.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    News findByIdAndIsDeletedIsFalse(Long id);
    List<News> findAllByIsDeletedIsFalse();
}