package com.fabrizio.spring.course.difactura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.spring.course.difactura.model.Invoice;
import com.fabrizio.spring.course.difactura.model.Product;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private Invoice invoice;
	@Autowired
	private Product product;
	
	@GetMapping("/view")
	public Invoice view() {
		return invoice;
	}
	
	@GetMapping("/viewProduct")
	public Product viewproduct() {
		return product;
	}
}
