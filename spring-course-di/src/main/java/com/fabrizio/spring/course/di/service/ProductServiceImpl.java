package com.fabrizio.spring.course.di.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import com.fabrizio.spring.course.di.model.Product;
import com.fabrizio.spring.course.di.repository.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{
	
	private ProductRepositoryImpl repository = new ProductRepositoryImpl();
	
	@Override
	public List<Product> findAll() {
		return repository.findAll().stream()
				.map(p -> {
					BigDecimal priceTax = p.getPrice()
							.multiply(new BigDecimal("1.25"))
							.setScale(2, RoundingMode.HALF_UP);
//					Product product = new Product(p.getId(), p.getName(), priceImp);
					Product product = (Product) p.clone(); 
					product.setPrice(priceTax);
					return product;
					})
				.collect(Collectors.toList());
	}
	
	@Override
	public Product findById(Long id) {
		return repository.findById(id);
	}
	
}
