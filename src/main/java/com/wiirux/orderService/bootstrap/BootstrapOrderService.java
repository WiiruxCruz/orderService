package com.wiirux.orderService.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiirux.orderService.domain.OrderHeader;
import com.wiirux.orderService.repositories.OrderHeaderRepository;

@Service
public class BootstrapOrderService {
	@Autowired
	OrderHeaderRepository ohr;
	
	@Transactional
	public void readOrderData() {
		OrderHeader oh = ohr.findById(3L).get();
		
		oh.getOrderLines().forEach( ol -> {
			System.out.println(ol.getProduct().getDescription());
			
			ol.getProduct().getCategories().forEach( cat -> {
				System.out.println(cat.getDescription());
			});
		});
	}
}
