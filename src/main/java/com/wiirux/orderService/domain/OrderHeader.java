package com.wiirux.orderService.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class OrderHeader extends BaseEntity{
	
	private String customer;
	
	public OrderHeader() {}
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customer);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		/*
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderHeader other = (OrderHeader) obj;
		return Objects.equals(customer, other.customer);
		*/
		
		if (this == obj) return true;
		if (!(obj instanceof OrderHeader)) return false;
		if (!super.equals(obj)) return false;
		
		OrderHeader that = (OrderHeader) obj;
		
		return getCustomer() != null ? getCustomer().equals(that.getCustomer()) : that.getCustomer() == null;
	}
	
	
	
}
