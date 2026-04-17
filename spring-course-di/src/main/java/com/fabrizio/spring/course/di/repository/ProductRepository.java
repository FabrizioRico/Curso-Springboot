package com.fabrizio.spring.course.di.repository;

import java.util.List;

import com.fabrizio.spring.course.di.model.Product;

public interface ProductRepository {
	
	List<Product> findAll();
	
	Product findById(Long id);

}
