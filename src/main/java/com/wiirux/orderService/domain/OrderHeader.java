package com.wiirux.orderService.domain;

import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@AttributeOverrides({
	@AttributeOverride(
		name = "shippingAddress.address",
		column = @Column(name = "shipping_address")
	),
	@AttributeOverride(
		name = "shippingAddress.city",
		column = @Column(name = "shipping_city")
	),
	@AttributeOverride(
		name = "shippingAddress.state",
		column = @Column(name = "shipping_state")
	),
	@AttributeOverride(
		name = "shippingAddress.zipCode",
		column = @Column(name = "shipping_zip_code")
	),
	@AttributeOverride(
		name = "billToAddress.address",
		column = @Column(name = "bill_to_address")
	),
	@AttributeOverride(
		name = "billToAddress.city",
		column = @Column(name = "bill_to_city")
	),
	@AttributeOverride(
		name = "billToAddress.state",
		column = @Column(name = "bill_to_state")
	),
	@AttributeOverride(
		name = "billToAddress.zipCode",
		column = @Column(name = "bill_to_zip_code")
	)
})
public class OrderHeader extends BaseEntity{
	
	private String customer;
	
	@Embedded
	private Address shippingAddress;
	
	@Embedded
	private Address billToAddress;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Address getBillToAddress() {
		return billToAddress;
	}
	public void setBillToAddress(Address billToAddress) {
		this.billToAddress = billToAddress;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(billToAddress, customer, orderStatus, shippingAddress);
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
		OrderHeader other = (OrderHeader) obj;
		return Objects.equals(billToAddress, other.billToAddress) && Objects.equals(customer, other.customer)
				&& orderStatus == other.orderStatus && Objects.equals(shippingAddress, other.shippingAddress);
	}
		
}
