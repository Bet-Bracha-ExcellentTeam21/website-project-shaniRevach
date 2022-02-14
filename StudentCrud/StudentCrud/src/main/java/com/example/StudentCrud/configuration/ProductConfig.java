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
			Product strawberryMacaroonCake = new Product("strawberry macaroon cake", "assets/images/strawberry macaroon cake.png", 90.0);
			productRepository.save(strawberryMacaroonCake);
			Product strawberryMousse = new Product("strawberry mousse", "assets/images/strawberry mousse.png", 27.0);
			productRepository.save(strawberryMousse);
			Product lemonEclair = new Product("lemon eclair", "assets/images/lemon eclair.png", 13.0);
			productRepository.save(lemonEclair);
			Product ferreroRocherEclair = new Product("ferrero rocher eclair", "assets/images/ferrero rocher eclair.png", 13.0);
			productRepository.save(ferreroRocherEclair);
			Product coffeeEclair = new Product("coffee eclair", "assets/images/coffee eclair.png", 13.0);
			productRepository.save(coffeeEclair);
		};
	}

}
