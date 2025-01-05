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

	//@Bean
	CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			String[] beanDefinitionNames = context.getBeanDefinitionNames();
			System.out.println("####################################################");
			Arrays.stream(beanDefinitionNames).forEach(System.out::println);
			System.out.println("####################################################");
		};
	}

	//@Bean
	CommandLineRunner commandLineRunner2(ProductRepository productRepository){
		return args -> {
			Product p1= new Product();
			p1.setName("product1");
			p1.setDescription("Apple s'associe à (RED) pour aider le Fonds mondial à lutter contre le sida et à offrir des soins essentiels à des millions de gens.");
			Product p2 = new Product();
			p2.setName("product2");
			p2.setDescription("AirPods 4 avec Réduction active du bruit offrent une expérience audio encore plus puissante et un boîtier de charge polyvalent.");
			Product p3 = new Product();
			p3.setName("product3");
			p3.setDescription("PC Gamer destiné plus particulièrement aux Gamers et aux Professionnels des métiers du Design au Maroc");

//			Product product1 = Product.builder().name("product1").build();
//			Product product2 = Product.builder().name("product2").build();
//			Product product3 = Product.builder().name("product3").build();
			productRepository.saveAll(List.of(p1,p2,p3));
		};
	}


}
