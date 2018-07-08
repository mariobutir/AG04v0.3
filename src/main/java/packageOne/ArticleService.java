package packageOne;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticleService {
	
	private ArticleRepository articleRepository;
	
	public void insert(Article article) {
		articleRepository.saveAndFlush(article);
	}
	public Optional<Article> find(long id) {
		return articleRepository.findById(id);
	}
	public List <Article> findAll() {
		return (List<Article>) articleRepository.findAll();
	}
}