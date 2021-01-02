package ma.todart;

import ma.todart.dao.CategoryRepository;
import ma.todart.dao.ProductRepository;
import ma.todart.entities.Category;
import ma.todart.entities.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class TodartApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(TodartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.save(new Category(null, "printers",null,null));
		categoryRepository.save(new Category(null,"Computer",null,null));
		categoryRepository.save(new Category(null, "smartphones",null,null));

		Random rnd = new Random();
		categoryRepository.findAll().forEach(c->{
			for (int i = 0; i <10 ; i++) {
				Product p = new Product();
				p.setName((RandomString.make(10)));
				p.setCurrentPrice(100+rnd.nextInt(1000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(c);
				p.setPhotoName("unknown.png");
				productRepository.save(p);

			}
		});
	}
}
