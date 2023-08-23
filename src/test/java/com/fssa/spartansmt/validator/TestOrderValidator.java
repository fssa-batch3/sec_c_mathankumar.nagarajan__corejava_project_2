package com.fssa.spartansmt.validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.OrderValidatorErrors;
import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.model.Order;
import com.fssa.spartansmt.model.OrderedProduct;

class TestOrderValidator {

	// Valid Order Details
	public static Order validOrderDetails() {

		List<OrderedProduct> orderedProductList = new ArrayList<>();
		OrderedProduct orderedProduct1 = new OrderedProduct(1, 1);
		OrderedProduct orderedProduct2 = new OrderedProduct();
		orderedProduct2.setProductId(4);
		orderedProduct2.setQuantity(2);
		OrderedProduct orderedProduct3 = new OrderedProduct(9, 3);
		orderedProductList.add(orderedProduct1);
		orderedProductList.add(orderedProduct2);
		orderedProductList.add(orderedProduct3);

		Order order = new Order(7, 12340.92, "NO", LocalDate.now(), orderedProductList);

		return order;

	}

	// Invalid Order Details
	public static Order invalidOrderDetatils() {

		Order order = new Order();
		order.setUserId(0);
		order.setPaymentStatus(null);
		order.setTotalPrice(0);
		order.setOrderDate(null);

		List<OrderedProduct> orderedProductList = null;

		order.setOrderedProducts(orderedProductList);

		return order;

	}

	/*
	 * Valid Test Cases
	 */
	@Test
	void testValidateOrder() throws InvalidOrderDetailsException {
		OrderValidator orderValidator = new OrderValidator();
		Assertions.assertTrue(orderValidator.validateOrder(validOrderDetails()));
	}

	@Test
	void testValidUserId() throws InvalidOrderDetailsException {
		Assertions.assertTrue(OrderValidator.validateUserId(validOrderDetails().getUserId()));
	}

	@Test
	void testValidateTotalPrice() throws InvalidOrderDetailsException {
		Assertions.assertTrue(OrderValidator.validateTotalPrice(validOrderDetails().getTotalPrice()));
	}

	@Test
	void testValidatePaymentStatue() throws InvalidOrderDetailsException {
		Assertions.assertTrue(OrderValidator.validatePaymentStatus(validOrderDetails().getPaymentStatus()));
	}

	@Test
	void testValidateOrderDate() throws InvalidOrderDetailsException {
		Assertions.assertTrue(OrderValidator.validateOrderDate(validOrderDetails().getOrderDate()));
	}

	@Test
	void testValidateOrderedProduct() throws InvalidOrderDetailsException {
		Assertions.assertTrue(OrderValidator.validateOrderdedProducts(validOrderDetails().getOrderedProducts()));
	}

	/*
	 * Invalid Test Cases
	 */
	@Test
	void testInvalidOrder() {
		try {
			Order order = null;
			OrderValidator orderValidator = new OrderValidator();
			orderValidator.validateOrder(order);
			Assertions.fail("Test Invalid Order Methos Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_ORDER, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderUserId() {
		try {
			OrderValidator.validateUserId(invalidOrderDetatils().getUserId());
			Assertions.fail("Test Invalid Order User Id Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_ID, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderTotalPrice() {
		try {
			OrderValidator.validateTotalPrice(invalidOrderDetatils().getTotalPrice());
			Assertions.fail("Test Invalid Order Total Price Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.ORDER_TOTAL_PRICE, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderPaymentStatus() {
		try {
			OrderValidator.validatePaymentStatus(invalidOrderDetatils().getPaymentStatus());
			Assertions.fail("Test Invalid Order Payment Status Methos Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_PAYMENT_STATUS, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderOrderedDate() {
		try {
			OrderValidator.validateOrderDate(invalidOrderDetatils().getOrderDate());
			Assertions.fail("Test Invalid Order Ordered Date Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_LOCALDATE, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderOrderedProducts() {
		try {
			OrderValidator.validateOrderdedProducts(invalidOrderDetatils().getOrderedProducts());
			Assertions.fail("Test Invalid Order Ordered Products Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_ORDERED_PRODUCT, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderOrderDate() {
		try {
			OrderValidator.validateOrderDate(LocalDate.parse("2023-07-01"));
			Assertions.fail("Test Invalid Order Orderdate Method is failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_LOCALDATE, ex.getMessage());
		}
	}

	@Test
	void testInvalidEmptyPaymentStatus() {
		try {
			OrderValidator.validatePaymentStatus("");
			Assertions.fail("Test Invalid Empty Payment Status Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_PAYMENT_STATUS, ex.getMessage());
		}
	}

	@Test
	void testInvalidNullOrderedProduct() {
		try {
			List<OrderedProduct> orderedProductList = new ArrayList<>();
			OrderedProduct orderedProduct = null;
			orderedProductList.add(orderedProduct);
			OrderValidator.validateOrderdedProducts(orderedProductList);
			Assertions.fail("Test Invalid Null Ordered Product Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_ORDERED_PRODUCT, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderedProductId() {
		try {
			List<OrderedProduct> orderedProductList = new ArrayList<>();
			OrderedProduct orderedProduct = new OrderedProduct(0, 2);
			orderedProductList.add(orderedProduct);
			OrderValidator.validateOrderdedProducts(orderedProductList);
			Assertions.fail("Test Invalid Ordered Product Id Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
	}

	@Test
	void testInvalidOrderedProductQuantity() {
		try {
			List<OrderedProduct> orderedProductList = new ArrayList<>();
			OrderedProduct orderedProduct = new OrderedProduct(2, 0);
			orderedProductList.add(orderedProduct);
			OrderValidator.validateOrderdedProducts(orderedProductList);
			Assertions.fail("Test Invalid Ordered Product Quantity Method Is Failded");
		} catch (InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_PRODUCT_QUANTITY, ex.getMessage());
		}
	}

}
