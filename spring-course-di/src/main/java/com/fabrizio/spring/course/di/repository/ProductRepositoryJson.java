package com.fabrizio.spring.course.di.repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fabrizio.spring.course.di.model.Product;

import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository{

	private List<Product> listProduct;
	
	private void readValueJson(Resource resource) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			listProduct = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ProductRepositoryJson() {
		Resource resource = new ClassPathResource("json/product.json");
		readValueJson(resource);
	}
	
	public ProductRepositoryJson(Resource resource) {
		readValueJson(resource);
	}
	

	
	@Override
	public List<Product> findAll() {
		return listProduct;
	}

	@Override
	public Product findById(Long id) {
		return listProduct.stream()
				.filter(p -> {return p.getId().equals(id);})
				.findFirst().orElseThrow();
	}

}
