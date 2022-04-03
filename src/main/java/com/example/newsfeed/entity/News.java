package com.example.newsfeed.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "is_deleted", columnDefinition = "boolean default 'false'")
    private boolean isDeleted;

    @OneToOne
    private NewsBody newsBody;

    @OneToOne
    private Image image;
}