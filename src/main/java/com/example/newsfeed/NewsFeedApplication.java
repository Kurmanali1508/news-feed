package com.example.newsfeed;

import com.example.newsfeed.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageConfig.class
})
public class NewsFeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);
    }

}
