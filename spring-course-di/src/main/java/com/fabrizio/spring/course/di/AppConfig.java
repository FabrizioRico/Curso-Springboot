package com.fabrizio.spring.course.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabrizio.spring.course.di.repository.ProductRepository;
import com.fabrizio.spring.course.di.repository.ProductRepositoryJson;

@Configuration
public class AppConfig {

	@Bean("productJson")
	ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson();
	}
}
