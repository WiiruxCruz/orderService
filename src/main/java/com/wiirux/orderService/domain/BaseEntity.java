package com.wiirux.orderService.domain;

import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		/*
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(id, other.id);
		*/
		
		if (this == obj) return true;
		if (!(obj instanceof BaseEntity)) return false;
		
		BaseEntity that = (BaseEntity) obj;
		
		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
