package com.fabrizio.spring.course.di.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fabrizio.spring.course.di.model.Product;
import com.fabrizio.spring.course.di.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
//	@Autowired
//	@Qualifier("productQux")
	@Value("${config.tax}")
	private BigDecimal tax;
	
	private ProductRepository repository;

	public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll().stream()
				.map(p -> {
					BigDecimal priceTax = p.getPrice()
							.multiply(tax)
							.setScale(2, RoundingMode.HALF_UP);
//					Product product = new Product(p.getId(), p.getName(), priceImp);
					Product product = (Product) p.clone(); 
					product.setPrice(priceTax);
					return product;
//					p.setPrice(priceTax);
//					return p;
					})
				.collect(Collectors.toList());
	}
	
	@Override
	public Product findById(Long id) {
		return repository.findById(id);
	}
	
}
