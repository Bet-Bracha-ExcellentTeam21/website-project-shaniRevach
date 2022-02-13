package com.example.StudentCrud.configuration;

import com.example.StudentCrud.domain.Product;
import com.example.StudentCrud.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

	@Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			Product opera = new Product("opera", "assets/images/opera.png", 20.0);
			productRepository.save(opera);
			Product chocolatePie = new Product("coconut chocolate mousse", "assets/images/coconut chocolate mousse.png", 15.0);
			productRepository.save(chocolatePie);
			Product chocolateEclair = new Product("chocolate eclair", "assets/images/chocolate eclair.png", 13.0);
			productRepository.save(chocolateEclair);
		};
	}
}
