package com.wiirux.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;

import com.wiirux.orderService.domain.OrderHeader;

//import jakarta.transaction.Transactional;


public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
	/*
	@Modifying
	@Transactional
	@Query(value = "delete from OrderHeader OH WHERE OH.id = ?1")
	void deleteById(Long id);
	*/
}
