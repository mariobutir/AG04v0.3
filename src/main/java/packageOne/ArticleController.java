package packageOne;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Controller
@Transactional
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

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
	
/*
	public void addtorepository(){
		
		String string = "January 2, 2010";
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Article article = new Article(date, 1L, "Samsung", "/samsung", "user", 0);
		articleRepository.save(article);
	}
*/
}
