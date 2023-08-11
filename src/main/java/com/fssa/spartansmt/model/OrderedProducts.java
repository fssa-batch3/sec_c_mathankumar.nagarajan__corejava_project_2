package com.fssa.spartansmt.model;

public class OrderedProducts {

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

	public OrderedProducts(int orderId, int productId, int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

}
