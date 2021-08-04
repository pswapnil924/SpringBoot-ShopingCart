package com.tudip.model;

import javax.persistence.*;

@Entity
@Table(name = "product_info")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private int productInStock;
	@Column(columnDefinition = "boolean default false")
	private boolean isProductOutOfStock;
	private float productPrice;

	public int getProductInStock() {
		return productInStock;
	}
	public void setProductInStock(int productInStock) {
		this.productInStock = productInStock;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isProductOutOfStock() {
		return isProductOutOfStock;
	}

	public void setProductOutOfStock(boolean productOutOfStock) {
		isProductOutOfStock = productOutOfStock;
	}
}
