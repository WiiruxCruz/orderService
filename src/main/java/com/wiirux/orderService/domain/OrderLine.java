package com.wiirux.orderService.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderLine extends BaseEntity {
	private Integer quantityOrdered;
	
	@ManyToOne
	private OrderHeader orderHeader;
	
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public OrderHeader getOrderHeader() {
		return orderHeader;
	}
	public void setOrderHeader(OrderHeader orderHeader) {
		this.orderHeader = orderHeader;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		//result = prime * result + ((orderHeader == null) ? 0 : orderHeader.hashCode());
		result = prime * result + ((quantityOrdered == null) ? 0 : quantityOrdered.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (orderHeader == null) {
			if (other.orderHeader != null)
				return false;
		} else if (!orderHeader.equals(other.orderHeader))
			return false;
		if (quantityOrdered == null) {
			if (other.quantityOrdered != null)
				return false;
		} else if (!quantityOrdered.equals(other.quantityOrdered))
			return false;
		return true;
	}
	

	
	
}
