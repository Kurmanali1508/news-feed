package com.example.newsfeed.entity.baseEntities;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "size")
    private Long size;

    @Column(name = "file_download_uri")
    private String fileDownloadUri;


}