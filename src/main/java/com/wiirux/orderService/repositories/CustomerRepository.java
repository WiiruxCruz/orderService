package com.wiirux.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.orderService.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
