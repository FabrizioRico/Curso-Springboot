package com.fabrizio.spring.course.difactura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.spring.course.difactura.model.Client;
import com.fabrizio.spring.course.difactura.model.Invoice;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private Invoice invoice;
	
	@GetMapping("/view")
	public Invoice view() {
		Invoice i = new Invoice();
		Client c = new Client();
		
		c.setName(invoice.getClient().getName());
		c.setLastname(invoice.getClient().getLastname());
		
		i.setClient(c);
		
		i.setDescription(invoice.getDescription());
		i.setItems(invoice.getItems());
		
		return i;
	}
	
}
