package com.fabrizio.spring.course.di.repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fabrizio.spring.course.di.model.Product;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository{

	private List<Product> listProduct;
	
	public ProductRepositoryJson() {
		Resource resource = new ClassPathResource("data/product.json");
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			listProduct = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
		} catch (JacksonException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
