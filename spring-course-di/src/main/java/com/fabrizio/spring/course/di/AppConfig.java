package com.fabrizio.spring.course.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.fabrizio.spring.course.di.repository.ProductRepository;
import com.fabrizio.spring.course.di.repository.ProductRepositoryJson;

@Configuration
public class AppConfig {

	@Value("classpath:data/product.json")
	private Resource resource;
	
	@Bean("productJson")
	ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson(resource);
	}
}
