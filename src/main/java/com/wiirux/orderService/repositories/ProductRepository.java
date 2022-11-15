package com.wiirux.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.orderService.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByDescription(String description);
}
