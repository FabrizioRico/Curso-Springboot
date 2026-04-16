package com.fabrizio.spring.course.di.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.fabrizio.spring.course.di.model.Product;

public class ProductRepository {

	private List<Product> data;
	
	public ProductRepository(){
		this.data = Arrays.asList(
			new Product(1L, "Teclado Teraware", new BigDecimal("70.5")), 
			new Product(2L, "Mouse Teraware", new BigDecimal("40.0")),
			new Product(3L, "Audifonos Teraware", new BigDecimal("30.0")),
			new Product(4L, "Monitor ViewSonic", new BigDecimal("150.0"))
		);	
	}
	
	public List<Product> findAll(){
		return data;
	}
	
	public Product findById(Long id) {
		return data.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst()
				.orElseThrow();
		
//		for (Product product : data) {
//			if(product.getId().equals(id)) {
//				return product;
//			}
//		}
//		throw new RuntimeException("No se ha encontrado");
	}
}
