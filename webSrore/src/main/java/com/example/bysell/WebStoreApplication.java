package com.example.bysell;

import com.example.bysell.controllers.ProductController;
import com.example.bysell.models.ProductDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
public class WebStoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(WebStoreApplication.class, args);

		ProductController productController = ctx.getBean(ProductController.class);
		for(ProductDTO product:
		productController.getAllProductsRest()){
			System.out.println(product.getTitle());
		}
	}
}
