package com.articleapp.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.articleapp.model.Article;
import com.articleapp.model.PagerModel;
import com.articleapp.model.Uservote;
import com.articleapp.repository.ArticleRepository;
import com.articleapp.repository.UserVoteRepository;
import com.articleapp.service.ArticleService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@Transactional
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	ArticleService articleService;
	@Autowired
	UserVoteRepository uservoteRepository;

	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };

	@GetMapping("/articles")
	public ModelAndView homepage(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page, Model model) {

		Uservote uservote = new Uservote();
		model.addAttribute("uservote", uservote);

		ModelAndView modelAndView = new ModelAndView("articles");

		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		System.out.println("here is article repo " + articleRepository.findAll());

		Page<Article> articleList = articleRepository.findAll(PageRequest.of(evalPage, evalPageSize));
		System.out.println("article list get total pages" + articleList.getTotalPages() + "article list get number "
				+ articleList.getNumber());

		for (Article ar : articleRepository.findAll()) {
			System.out.println(ar.getbrojglasova());
		}

		PagerModel pager = new PagerModel(articleList.getTotalPages(), articleList.getNumber(), BUTTONS_TO_SHOW);
		modelAndView.addObject("articleList", articleList);

		modelAndView.addObject("selectedPageSize", evalPageSize);

		modelAndView.addObject("pageSizes", PAGE_SIZES);

		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

	@PostMapping("/articles")
	public String saveJob(@Valid @ModelAttribute("uservote") Uservote uservote, BindingResult bindingResult,
			Model model, @RequestParam(value = "articleid") Long id, @RequestParam(value = "votevalue") String vote,
			@RequestParam(value = "userarticleid") String userarticleid) {

		if (bindingResult.hasErrors()) {
			return "articles";
		}

		Article article = articleService.findById(id);
		Integer broj = (int) article.getbrojglasova();

		if (uservoteRepository.existsById(userarticleid)) {
			if (uservoteRepository.findById(userarticleid).get().getVote().equals(vote)) {
				return "redirect:/articles";
			} else {
				uservoteRepository.save(uservote);
				if (vote.equals("up")) {
					article.setbrojglasova(broj + 1);
				} else {
					article.setbrojglasova(broj - 1);
				}
			}
		} else {
			uservoteRepository.save(uservote);
			if (vote.equals("up")) {
				article.setbrojglasova(broj + 1);
			} else {
				article.setbrojglasova(broj - 1);
			}
		}
		
		articleRepository.save(article);

		/*
		 * Article article = articleService.findById(id); Integer broj = (int)
		 * article.getbrojglasova();
		 * 
		 * System.out.println("----------" + id); System.out.println("----------" +
		 * vote);
		 * 
		 * if (vote.equals("up")) { article.setbrojglasova(broj + 1); } else {
		 * article.setbrojglasova(broj - 1); }
		 * 
		 * articleRepository.save(article);
		 */

		return "redirect:/articles";
	}

	@GetMapping("/add-article")
	public String addArticle(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);

		return "add-article";
	}

	@PostMapping("/add-article")
	public String article(@Valid @ModelAttribute("article") Article article, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "add-article";
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		article.setKorisnik(name);
		article.setbrojglasova(0);
		article.setvrijemeunosa(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		articleService.add(article);
		return "redirect:/articles";
	}

	@GetMapping("/delete-article")
	public ModelAndView homepage2(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page, Model model) {

		ModelAndView modelAndView = new ModelAndView("delete-article");

		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		System.out.println("here is article repo " + articleRepository.findAll());

		Page<Article> articleList = articleRepository.findAll(PageRequest.of(evalPage, evalPageSize));

		System.out.println("article list get total pages" + articleList.getTotalPages() + "article list get number "
				+ articleList.getNumber());

		PagerModel pager = new PagerModel(articleList.getTotalPages(), articleList.getNumber(), BUTTONS_TO_SHOW);
		modelAndView.addObject("articleList", articleList);

		modelAndView.addObject("selectedPageSize", evalPageSize);

		modelAndView.addObject("pageSizes", PAGE_SIZES);

		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

	@PostMapping("/delete-article")
	public String delete(@RequestParam(value = "articlesid", required = false) Long[] articles) {
		if (articles != null) {
			for (int i = 0; i < articles.length; i++) {
				if (articleRepository.existsById(articles[i])) {
					articleRepository.deleteById(articles[i]);
				}
			}
		}

		return "redirect:/delete-article";

	}
}
