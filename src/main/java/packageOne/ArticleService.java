package packageOne;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ArticleService {
	
	@PersistenceContext
	private EntityManager entityManager;
	public long insert(Article article) {
		entityManager.persist(article);
		return article.getId();
	}
	public Article find(long id) {
		return entityManager.find(Article.class, id);
	}
	public List <Article> findAll() {
		Query query = entityManager.createNamedQuery(
				"query_find_all_users", Article.class);
		return query.getResultList();
	}
}
