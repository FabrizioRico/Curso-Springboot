package com.fabrizio.spring.course.di.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.spring.course.di.model.Product;
import com.fabrizio.spring.course.di.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductController {
	
//	private ProductService service = new ProductService();

	@GetMapping
	public List<Product> list() {
		ProductServiceImpl service = new ProductServiceImpl();
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Product show(@PathVariable Long id) {
		ProductServiceImpl service = new ProductServiceImpl();
		return service.findById(id);
	}
}
