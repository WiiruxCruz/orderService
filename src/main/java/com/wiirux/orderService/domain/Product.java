package com.wiirux.orderService.domain;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Product extends BaseEntity {
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ProductStatus productStatus;
	
	@ManyToMany
	@JoinTable(
		name = "product_category",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private Set<Category> categories;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((productStatus == null) ? 0 : productStatus.hashCode());
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
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (productStatus != other.productStatus)
			return false;
		return true;
	}

	
}
