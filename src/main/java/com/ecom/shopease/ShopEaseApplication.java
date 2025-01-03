package com.ecom.shopease;

import com.ecom.shopease.entities.Product;
import com.ecom.shopease.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ShopEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopEaseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			String[] beanDefinitionNames = context.getBeanDefinitionNames();
			System.out.println("####################################################");
			Arrays.stream(beanDefinitionNames).forEach(System.out::println);
			System.out.println("####################################################");
		};
	}

	@Bean
	CommandLineRunner commandLineRunner2(ProductRepository productRepository){
		return args -> {
			Product product1 = Product.builder().name("product1").build();
			Product product2 = Product.builder().name("product2").build();
			Product product3 = Product.builder().name("product3").build();
			productRepository.saveAll(List.of(product1,product2,product3));
		};
	}


}
