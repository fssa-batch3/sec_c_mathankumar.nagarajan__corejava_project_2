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
	private String paymentOption;
	private double totalPrice;
	private LocalDate orderDate;
	private List<OrderedProduct> orderedProducts; 
	
	// Address Details
	private String address;
	private String country;
	private String state;
	private int zipCode;

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

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
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

	
	// Address Getters and Setters
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Order(int userId, double totalPrice, String paymentOption, LocalDate orderDate, List<OrderedProduct> orderedProducts) {
		this.userId = userId;
		this.paymentOption = paymentOption;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.orderedProducts = orderedProducts;
	}

	
	
	public Order(int userId, String paymentOption, double totalPrice, LocalDate orderDate,
			List<OrderedProduct> orderedProducts, String address, String country, String state, int zipCode) {
		super();
		this.userId = userId;
		this.paymentOption = paymentOption;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.orderedProducts = orderedProducts;
		this.address = address;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
	}

	// Empty Constructor
	public Order() {
		// Default Constructor
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", paymentOption=" + paymentOption + ", totalPrice="
				+ totalPrice + ", orderDate=" + orderDate + ", orderedProducts=" + orderedProducts + ", address="
				+ address + ", country=" + country + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	
	

}
