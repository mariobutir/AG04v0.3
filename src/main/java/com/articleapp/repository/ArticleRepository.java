package com.articleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.articleapp.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findById(long id);
	
}
