package com.wiirux.orderService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.wiirux.orderService.domain.Product;
import com.wiirux.orderService.domain.ProductStatus;
import com.wiirux.orderService.repositories.ProductRepository;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.wiirux.orderservice.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
	
	@Autowired
	ProductRepository pr;
	
	@Test
	void testSaveProduct() {
		Product product = new Product();
		product.setDescription("My product");
		product.setProductStatus(ProductStatus.NEW);
		
		Product savedProduct = pr.save(product);
		
		Product fetchedProduct = pr.getById(savedProduct.getId());
		
		assertNotNull(fetchedProduct);
		assertNotNull(fetchedProduct.getDescription());
		assertNotNull(fetchedProduct.getCreatedDate());
		assertNotNull(fetchedProduct.getLastModifiedDate());
	}
}