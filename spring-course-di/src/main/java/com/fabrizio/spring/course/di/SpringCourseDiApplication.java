package com.fabrizio.spring.course.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.fabrizio.spring.course.di.repository.ProductRepository;
import com.fabrizio.spring.course.di.repository.ProductRepositoryJson;

@SpringBootApplication
public class SpringCourseDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseDiApplication.class, args);
	}

}
