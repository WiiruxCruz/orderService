package com.wiirux.orderService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiirux.orderService.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
