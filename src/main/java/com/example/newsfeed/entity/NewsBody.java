package com.example.newsfeed.entity;

import com.example.newsfeed.entity.baseEntities.BaseFileEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "news")
public class NewsBody extends BaseFileEntity {
    @Column(name = "file_name")
    private String fileName;
}