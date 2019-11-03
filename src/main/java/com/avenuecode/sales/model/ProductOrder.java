package com.avenuecode.sales.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class ProductOrder extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodOrderId;

	@ManyToMany
	private Collection<Product> prod = new ArrayList<>();

	public ProductOrder() {
	}

	public ProductOrder(int prodOrderId, Collection<Product> prod) {
		super();
		this.prodOrderId = prodOrderId;
		this.prod = prod;
	}

	public int getProdOrderId() {
		return prodOrderId;
	}

	public void setProdOrderId(int prodOrderId) {
		this.prodOrderId = prodOrderId;
	}

	public Collection<Product> getProd() {
		return prod;
	}

	public void setProd(Collection<Product> prod) {
		this.prod = prod;
	}

}
