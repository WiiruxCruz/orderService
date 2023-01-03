package com.wiirux.orderService.domain;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
	@Embedded
	private Address shippingAddress;
	
	@Embedded
	private Address billToAddress;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "orderHeader", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	//private Set<OrderLine> orderLines = new HashSet<>();
	private Set<OrderLine> orderLines;
	
	//@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "orderHeader")
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@Fetch(FetchMode.SELECT)
	private OrderApproval orderApproval;
	
	public void addOrderLine(OrderLine orderLine) {
		if (orderLines == null) {
			orderLines = new HashSet<>();
		}
		
		orderLines.add(orderLine);
		orderLine.setOrderHeader(this);
		
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
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
	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	public OrderApproval getOrderApproval() {
		return orderApproval;
	}
	public void setOrderApproval(OrderApproval orderApproval) {
		this.orderApproval = orderApproval;
		orderApproval.setOrderHeader(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billToAddress == null) ? 0 : billToAddress.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderLines == null) ? 0 : orderLines.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
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
		if (billToAddress == null) {
			if (other.billToAddress != null)
				return false;
		} else if (!billToAddress.equals(other.billToAddress))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderLines == null) {
			if (other.orderLines != null)
				return false;
		} else if (!orderLines.equals(other.orderLines))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (shippingAddress == null) {
			if (other.shippingAddress != null)
				return false;
		} else if (!shippingAddress.equals(other.shippingAddress))
			return false;
		return true;
	}
	
}
