package com.wiirux.orderService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.wiirux.orderService.domain.OrderHeader;
import com.wiirux.orderService.repositories.OrderHeaderRepository;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.wiirux.orderservice.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderHeaderTest {
	@Autowired
	OrderHeaderRepository ohr;
	
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
	void testSaveOrder() {
		OrderHeader oh = new OrderHeader();
		oh.setCustomer("New Customer");
		OrderHeader saveOrder = ohr.save(oh);
		
		assertNotNull(saveOrder);
		assertNotNull(saveOrder.getId());
		
		OrderHeader fetchedOrder = ohr.getById(saveOrder.getId());
		
		assertNotNull(fetchedOrder);
		assertNotNull(fetchedOrder.getId());
		assertNotNull(fetchedOrder.getCreatedDate());
	}
}
