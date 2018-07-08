package packageOne;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("/articles")
	public List<Article> retrieveAllArticles() {
		return articleRepository.findAll();
	}

	@GetMapping("/articles/{id}")
	public Article retrieveArticle(@PathVariable long id) throws ArticleNotFoundException {
		Optional<Article> article = articleRepository.findById(id);

		if (!article.isPresent())
			throw new ArticleNotFoundException();
		
		return article.get();
	}

	@DeleteMapping("/articles/{id}")
	public void deleteArticle(@PathVariable long id) {
		articleRepository.deleteById(id);
	}

	@PostMapping("/articles")
	public ResponseEntity<Object> createArticle(@RequestBody Article article) {
		Article savedArticle = articleRepository.save(article);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedArticle.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/articles/{id}")
	public ResponseEntity<Object> updateArticle(@RequestBody Article article, @PathVariable long id) {

		Optional<Article> articleOptional = articleRepository.findById(id);

		if (!articleOptional.isPresent())
			return ResponseEntity.notFound().build();

		article.setId(id);
		articleRepository.save(article);
		return ResponseEntity.noContent().build();
	}
}
