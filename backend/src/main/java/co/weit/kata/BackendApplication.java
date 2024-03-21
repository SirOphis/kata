package co.weit.kata;

import co.weit.kata.entity.Product;
import co.weit.kata.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	@Autowired
	private ProductService productService;
	@Override
	public void run(String... args) throws Exception {
		productService.fetchAndSaveProducts();
	}


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
