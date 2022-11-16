package com.wiirux.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.orderService.domain.OrderApproval;

public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long>{

}
