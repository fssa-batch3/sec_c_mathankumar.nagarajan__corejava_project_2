package com.fssa.spartansmt.model;

import java.time.LocalDate;

/*
 * @author MathankumarNagarajan
 * 
 * Product Object Model
 * This class representing a product in the SpartansMt application.
 * This class defines the structure of a product object and its
 * associated attributes. Each product in the SpartansMt application is
 * represented by an instance of this class.
 */

public class Product {

	private int productId;
	private String productTitle;
	private double productPrice;
	private String productImage;
	private int storeId;
	private LocalDate uploadedDate;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public LocalDate getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(LocalDate uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public Product(String productTitle, double productPrice, String productImage, int storeId, LocalDate uploadedDate) {
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.storeId = storeId;
		this.uploadedDate = uploadedDate;
	}

	public Product() {

	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", productPrice=" + productPrice
				+ ", productImage=" + productImage + ", storeId=" + storeId + "]";
	}

}
