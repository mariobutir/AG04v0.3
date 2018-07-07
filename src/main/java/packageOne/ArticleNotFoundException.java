package packageOne;

public class ArticleNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ArticleNotFoundException() {
		System.out.println("Article not found!");
	}

}
