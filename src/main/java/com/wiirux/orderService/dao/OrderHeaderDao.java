package com.wiirux.orderService.dao;

import com.wiirux.orderService.domain.OrderHeader;

public interface OrderHeaderDao {
	OrderHeader getById(Long id);
}
