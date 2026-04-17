package com.fabrizio.spring.course.di.service;

import java.util.List;
import com.fabrizio.spring.course.di.model.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(Long id);
}
