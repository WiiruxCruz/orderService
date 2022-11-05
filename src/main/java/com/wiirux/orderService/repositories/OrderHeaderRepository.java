package com.wiirux.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.orderService.domain.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {

}
