package com.fssa.spartansmt.model;

public class Order {

	private int orderId;
	private int userId;
	private String status;
	private int totalPrice;
	private int quentity;
	private int productId;
	
	public Order(int userId, int productId, int totalPrice) {
		super();
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.productId = productId;
		this.status = "NO";
		this.quentity = 1;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuentity() {
		return quentity;
	}

	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	

}
