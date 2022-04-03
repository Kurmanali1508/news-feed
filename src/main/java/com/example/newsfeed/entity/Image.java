package com.example.newsfeed.entity;

import com.example.newsfeed.entity.baseEntities.BaseFileEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
public class Image extends BaseFileEntity {
    @Column(name = "image_name")
    private String imageName;
}