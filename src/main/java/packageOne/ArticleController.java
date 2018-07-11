package packageOne;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Controller
@Transactional
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	ArticleService articleService;

	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };

	@GetMapping("/articles")
	public ModelAndView homepage(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {

		ModelAndView modelAndView = new ModelAndView("articles");

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

	@GetMapping("/add-article")
	public String addArticle(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "add-article";
	}
	
	@PostMapping("/add-article")
    public String article(@ModelAttribute("article") Article article, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "add-article";
        }

        articleService.add(article);
        return "redirect:/add-articles?success";
    }
}
