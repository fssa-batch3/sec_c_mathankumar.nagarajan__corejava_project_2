package com.fssa.spartansmt.model;

import java.time.LocalDate;

public class Order {

	private int userId;
	private String paymentStatus;
	private int totalPrice;
	private LocalDate orderDate;
	private OrderedProducts orderedProducts;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderedProducts getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(OrderedProducts orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	public Order(int userId, String paymentStatus, int totalPrice, LocalDate orderDate, OrderedProducts orderedProducts) {
		this.userId = userId;
		this.paymentStatus = paymentStatus;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.orderedProducts = orderedProducts;
	}

}
