package com.wiirux.orderService.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
@AttributeOverrides({
	@AttributeOverride(
		name = "name",
		column = @Column(name = "customer_name")
	)
})
public class Customer extends BaseEntity {
	private String name;
	
	@Embedded
	private Address customerAddress;
	
	private String phone;
	private String email;
	
	@Version
	private Integer version;
	
	@OneToMany(mappedBy = "customer")
	private Set<OrderHeader> orderHeaders = new LinkedHashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<OrderHeader> getOrderHeaders() {
		return orderHeaders;
	}
	public void setOrderHeaders(Set<OrderHeader> orderHeaders) {
		this.orderHeaders = orderHeaders;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
