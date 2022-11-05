package com.wiirux.orderService;

import static org.assertj.core.api.Assertions.assertThat;
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
	void testSaveOrder() {
		OrderHeader oh = new OrderHeader();
		oh.setCustomer("New Customer");
		OrderHeader saveOrder = ohr.save(oh);
		
		assertNotNull(saveOrder);
		assertNotNull(saveOrder.getId());
		
		OrderHeader fetchedOrder = ohr.getById(saveOrder.getId());
		
		assertNotNull(fetchedOrder);
		assertNotNull(fetchedOrder.getId());
	}
}
