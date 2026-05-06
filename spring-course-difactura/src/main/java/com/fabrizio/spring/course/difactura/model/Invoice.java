package com.fabrizio.spring.course.difactura.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Invoice {
	
	@Autowired
	private Client client;
	
	@Value("${invoice.description.office}")
	private String description;
	
	@Autowired
	@Qualifier("default")
	private List<Item> items;
	
	
	public Invoice() {
		System.out.println(client);
		System.out.println(description);
	}

	@PostConstruct
	public void innit() {
		System.out.println("Creando el componente de la factura");
		client.setName(client.getName() + " Omar");
		description = description + " del cliente " + client.getName() + client.getLastname();
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destruyendo el componente Invoice");
	}
	
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
