package com.wiirux.orderService.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wiirux.orderService.domain.Customer;
import com.wiirux.orderService.domain.OrderHeader;
import com.wiirux.orderService.repositories.CustomerRepository;
import com.wiirux.orderService.repositories.OrderHeaderRepository;

@Component
public class Bootstrap implements CommandLineRunner {
	
	@Autowired
	OrderHeaderRepository ohr;
	
	@Autowired
	BootstrapOrderService bos;
	
	@Autowired
	CustomerRepository cr;
	
	//@Transactional
	@Override
	public void run(String... args) throws Exception {
		/*
		//si se omite la anotación de transacción spring genera una transaccion implicita solo para el repository
		OrderHeader oh = ohr.findById(3L).get();
		
		//si se omite la anotación de transacción, el sig codigo esta fuera del scope de transaccion y mandara error
		oh.getOrderLines().forEach( ol -> {
			System.out.println(ol.getProduct().getDescription());
			
			ol.getProduct().getCategories().forEach( cat -> {
				System.out.println(cat.getDescription());
			});
		});
		*/
		bos.readOrderData();
		
		Customer customer = new Customer();
		customer.setName("Testing version");
		Customer savedCustomer = cr.save(customer);
		
		savedCustomer.setName("Testing version 2");
		Customer savedCustomer2 = cr.save(savedCustomer);
		System.out.println("Version is: " + savedCustomer2.getVersion());
		
		savedCustomer2.setName("Testing version 3");
		Customer savedCustomer3 = cr.save(savedCustomer2);
		System.out.println("Version is: " + savedCustomer3.getVersion());
		
		//cr.deleteById(savedCustomer.getId());
		cr.delete(savedCustomer3);
	}
}
