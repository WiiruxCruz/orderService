package com.wiirux.orderService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.orderService.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	//Los nombres en la busqueda deben coincidir con los nombres de los atributos de la clase
	Optional<Customer> findCustomerByNameIgnoreCase(String customerName);
}
