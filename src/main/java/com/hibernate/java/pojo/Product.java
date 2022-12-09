package com.hibernate.java.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;

	// ManyToOne fetch default EAGER
	// anh xa nhieu hang - 1 hang p -c
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;

	@ManyToMany
	@JoinTable(name = "prod_manufacture", joinColumns = { @JoinColumn(name = "productId") }, inverseJoinColumns = {
			@JoinColumn(name = "manufactureId") })
	private Set<Manufacture> manufacture;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Manufacture> getManufacture() {
		return manufacture;
	}

	public void setManufacture(Set<Manufacture> manufacture) {
		this.manufacture = manufacture;
	}
}
