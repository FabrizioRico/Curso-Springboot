package com.fabrizio.spring.course.difactura.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {
	
	@Autowired
	private Client client;
	@Value("${invoice.description}")
	private String description;
	@Autowired
	private List<Item> items;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public BigDecimal getTotal() {
//		BigDecimal cero = BigDecimal.ZERO;
//		for (Item item : items) {
//		cero = cero.add(item.getImporte());
//		}
//		return cero;asdsad
		return items.stream()
				.map(item -> item.getImporte())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
}
