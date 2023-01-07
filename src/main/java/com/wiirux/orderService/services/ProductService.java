package com.wiirux.orderService.services;

import com.wiirux.orderService.domain.Product;

public interface ProductService {
	Product saveProduct(Product product);
	
	Product updateQOH(Long id, Integer quantityOnHand);
}
