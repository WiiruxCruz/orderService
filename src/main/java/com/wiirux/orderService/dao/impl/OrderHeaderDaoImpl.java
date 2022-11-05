package com.wiirux.orderService.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;

import com.wiirux.orderService.dao.OrderHeaderDao;
import com.wiirux.orderService.domain.OrderHeader;
import com.wiirux.orderService.repositories.OrderHeaderRepository;

@Component
public class OrderHeaderDaoImpl implements OrderHeaderDao{
	
	@Autowired
	OrderHeaderRepository ohr;
	
	@Override
	public OrderHeader getById(Long id) {
		// TODO Auto-generated method stub
		return ohr.getById(id);
	}

}
