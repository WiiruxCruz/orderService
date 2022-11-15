package com.wiirux.orderService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.wiirux.orderService.domain.Address;
import com.wiirux.orderService.domain.Customer;
import com.wiirux.orderService.domain.OrderHeader;
import com.wiirux.orderService.domain.OrderLine;
import com.wiirux.orderService.domain.Product;
import com.wiirux.orderService.domain.ProductStatus;
import com.wiirux.orderService.repositories.CustomerRepository;
import com.wiirux.orderService.repositories.OrderHeaderRepository;
import com.wiirux.orderService.repositories.ProductRepository;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.wiirux.orderservice.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderHeaderTest {
	@Autowired
	OrderHeaderRepository ohr;
	
	@Autowired
	ProductRepository pr;
	
	@Autowired
	CustomerRepository cr;
	
	Product product;
	//Customer customer;
	
	@BeforeEach
	void setup() {
		Product newProduct = new Product();
		newProduct.setProductStatus(ProductStatus.NEW);
		newProduct.setDescription("test product");
		product = pr.saveAndFlush(newProduct);
		
		/*
		Address customer_address = new Address();
		customer_address.setAddress("Veracruz address");
		customer_address.setCity("Veracruz");
		customer_address.setState("Veracruz");
		customer_address.setZipCode("12345");
		
		Customer newCustomer = new Customer();
		newCustomer.setName("Hiram Ramirez");
		newCustomer.setEmail("correo@ejemplo.com");
		newCustomer.setPhone("1234567890");
		newCustomer.setCustomerAddress(customer_address);
		
		customer = cr.saveAndFlush(newCustomer); 
		
		cr.flush();
		*/
	}
	
	@Test
	void testEquals() {
		OrderHeader oh1 = new OrderHeader();
		oh1.setId(1L);
		
		OrderHeader oh2 = new OrderHeader();
		oh2.setId(1L);
		
		assert oh1.equals(oh2);
	}
	
	@Test
	void testNotEquals() {
		OrderHeader oh1 = new OrderHeader();
		oh1.setId(1L);
		
		OrderHeader oh2 = new OrderHeader();
		oh2.setId(3L);
		
		assertFalse( oh1.equals(oh2) );
	}
	
	@Test
	void testSaveOrderWithLine() {
		
		OrderHeader oh = new OrderHeader();
		
		Customer customer = new Customer();
		customer.setName("New Customer");
		Customer savedCustomer = cr.save(customer);
		oh.setCustomer(savedCustomer);
		
		OrderLine ol = new OrderLine();
		ol.setQuantityOrdered(5);
		ol.setProduct(product);
		
		//oh.setOrderLines(Set.of(ol));
		//ol.setOrderHeader(oh);
		oh.addOrderLine(ol);
		
		OrderHeader saveOrder = ohr.save(oh);
		
		ohr.flush();
		
		assertNotNull(saveOrder);
		assertNotNull(saveOrder.getId());
		assertNotNull(saveOrder.getOrderLines());
		assertEquals(saveOrder.getOrderLines().size(), 1);
		
		OrderHeader fetchedOrder = ohr.getById(saveOrder.getId());
		
		assertNotNull(fetchedOrder);
		assertEquals(fetchedOrder.getOrderLines().size(), 1);
	}
	
	@Test
	void testSaveOrder() {
		
		OrderHeader oh = new OrderHeader();
		Customer customer = new Customer();
		customer.setName("New Customer");
		Customer savedCustomer = cr.save(customer);
		
		oh.setCustomer(savedCustomer);
		OrderHeader saveOrder = ohr.save(oh);
		
		assertNotNull(saveOrder);
		assertNotNull(saveOrder.getId());
		
		OrderHeader fetchedOrder = ohr.getById(saveOrder.getId());
		
		assertNotNull(fetchedOrder);
		assertNotNull(fetchedOrder.getId());
		assertNotNull(fetchedOrder.getCreatedDate());
		assertNotNull(fetchedOrder.getLastModifiedDate());
	}
}
