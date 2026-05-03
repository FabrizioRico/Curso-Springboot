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

	@Bean
	List<Item> itemsInvoice(){
		Product p1 = new Product("Mando Logitech F510", new BigDecimal("90.0"));
		Product p2 = new Product("Camara Halión HD", new BigDecimal("100.0"));
		List<Item> listItems = new ArrayList<>();
		listItems.add(new Item(p1, 2));
		listItems.add(new Item(p2, 5));
		return listItems;
	}
}
