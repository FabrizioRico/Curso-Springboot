package com.fabrizio.spring.course.di.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fabrizio.spring.course.di.model.Product;

@Component
public class ProductRepositoryImpl implements ProductRepository{

	private List<Product> data;
	
	public ProductRepositoryImpl(){
		this.data = Arrays.asList(
			new Product(1L, "Teclado Teraware", new BigDecimal("70.5")), 
			new Product(2L, "Mouse Teraware", new BigDecimal("40.0")),
			new Product(3L, "Audifonos Teraware", new BigDecimal("30.0")),
			new Product(4L, "Monitor ViewSonic", new BigDecimal("150.0"))
		);	
	}
	
	@Override
	public List<Product> findAll(){
		return data;
	}
	
	@Override
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
