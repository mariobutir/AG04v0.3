package com.articleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.articleapp.repository.ArticleRepository;

@SpringBootApplication
@EnableJpaRepositories("com.articleapp.repository")
@EntityScan( basePackages = {"com.articleapp.model"} )
public class Application {
	
	@Autowired
	ArticleRepository articleRepository;

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

}