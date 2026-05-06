package com.fabrizio.spring.course.difactura;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fabrizio.spring.course.difactura.model.Item;
import com.fabrizio.spring.course.difactura.model.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

//	@Primary
	@Bean
	List<Item> itemsInvoice(){
		Product p1 = new Product("Mando Logitech F510", new BigDecimal("90.0"));
		Product p2 = new Product("Camara Halión HD", new BigDecimal("100.0"));
		List<Item> listItems = new ArrayList<>();
		listItems.add(new Item(p1, 2));
		listItems.add(new Item(p2, 5));
		return listItems;
	}

	@Bean("default")
	List<Item> itemsInvoiceOffice(){
		Product p1 = new Product("Teclado RGB Teraware", new BigDecimal("60.0"));
		Product p2 = new Product("Mouse RGB Halion", new BigDecimal("40.0"));
		Product p3 = new Product("Alfombra de mouse", new BigDecimal("10.0"));
		Product p4 = new Product("Audifono RGB Teraware", new BigDecimal("50.0"));
		List<Item> listItems = new ArrayList<>();
		listItems.add(new Item(p1, 4));
		listItems.add(new Item(p2, 5));
		listItems.add(new Item(p3, 2));
		listItems.add(new Item(p4, 9));
		return listItems;
	}
}
