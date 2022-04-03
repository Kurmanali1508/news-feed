package com.example.newsfeed.repository;

import com.example.newsfeed.entity.NewsBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsBodyRepository extends JpaRepository<NewsBody, Long> {
}