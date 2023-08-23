package com.fssa.spartansmt.model;

import java.time.LocalDate;
import java.util.List;

/*
 * @author MathankumarNagarajan
 * 
 * Order Model Object
 * This class defines the structure of a Order object and its
 * have associated attributes.
 * 
 * It has Getters and Setters method to get value to the variable and 
 * to set value to the variables.
 */

public class Order {

	private int orderId;
	private int userId;
	private String paymentStatus;
	private double totalPrice;
	private LocalDate orderDate;
	private List<OrderedProduct> orderedProducts; 

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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	public Order(int userId, double totalPrice, String paymentStatus, LocalDate orderDate, List<OrderedProduct> orderedProducts) {
		this.userId = userId;
		this.paymentStatus = paymentStatus;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.orderedProducts = orderedProducts;
	}

	// Empty Constructor
	public Order() {
		// Default Constructor
	}
	
	

}
