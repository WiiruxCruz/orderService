package com.wiirux.orderService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.orderService.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByDescription(String description);
}
