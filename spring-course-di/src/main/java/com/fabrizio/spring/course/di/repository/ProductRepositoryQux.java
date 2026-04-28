package com.fabrizio.spring.course.di.repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fabrizio.spring.course.di.model.Product;

@Repository("productQux")
public class ProductRepositoryQux implements ProductRepository{

	@Override
	public List<Product> findAll() {
		return Collections.singletonList(new Product(1L, "Altomayo Coffe bag 20g", new BigDecimal("12.0")));
	}

	@Override
	public Product findById(Long id) {

		return new Product(id, "Altomayo Coffe bag 20g", new BigDecimal("50.6"));
	}

}
