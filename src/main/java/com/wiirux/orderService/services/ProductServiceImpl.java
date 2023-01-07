package com.wiirux.orderService.services;

import org.springframework.stereotype.Service;

import com.wiirux.orderService.domain.Product;
import com.wiirux.orderService.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	private final ProductRepository pr;
	
	public ProductServiceImpl(ProductRepository pr) {
		this.pr = pr;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return pr.saveAndFlush(product);
	}
	
	@Transactional
	@Override
	public Product updateQOH(Long id, Integer quantityOnHand) {
		// TODO Auto-generated method stub
		Product product = pr.findById(id).orElseThrow();
		product.setQuantityOnHand(quantityOnHand);
		return pr.saveAndFlush(product);
	}
}
