package packageOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"packageOne"} )
public class Application {
	
	@Autowired
	ArticleRepository articleRepository;

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

}