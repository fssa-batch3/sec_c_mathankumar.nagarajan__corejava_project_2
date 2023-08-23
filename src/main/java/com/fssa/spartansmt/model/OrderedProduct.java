package com.fssa.spartansmt.model;

/*
 * @author MathankumarNagarajan
 * 
 * Ordered Product Object
 * It has Getter and Setter Methods
 */

public class OrderedProduct {

	private int orderId;
	private int productId;
	private int quantity;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quentity) {
		this.quantity = quentity;
	}

	public OrderedProduct(int productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	// Default Constructor
	public OrderedProduct() {
		
	}

}
