package com.articleapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.articleapp.model.Article;
import com.articleapp.repository.ArticleRepository;

@Service
public class ArticleService {

	private ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public void insert(Article article) {
		this.articleRepository.saveAndFlush(article);
	}

	public Article findById(long id) {
		return this.articleRepository.findById(id);
	}

	public List<Article> findAll() {
		return this.articleRepository.findAll();
	}

	public void add(Article article) {
		this.articleRepository.save(article);
	}
}