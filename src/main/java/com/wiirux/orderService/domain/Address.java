package com.wiirux.orderService.domain;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String address;
	@Length(max = 30)
	private String city;
	private String state;
	private String zipCode;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, city, state, zipCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(state, other.state) && Objects.equals(zipCode, other.zipCode);
	}
	
	
	
}
