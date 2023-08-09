package com.fssa.spartansmt.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.OrderValidatorErrors;
import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.Order;

class TestOrderValidator {
	
	static Order validOrder() {
		Order order = new Order(1, 1, 1999);
		return order;
	}

	static OrderValidator orderValidator() {
		OrderValidator ov = new OrderValidator();
		return ov;
	}
	
	@Test
	void testValidOrder() throws InvalidProductDetailsException, InvalidUserException, InvalidOrderDetailsException {
		Assertions.assertTrue(orderValidator().validateOrder(validOrder()));
	}
	
	@Test
	void testValidUserId() throws InvalidUserException {
		Assertions.assertTrue(orderValidator().validateUserId(validOrder().getUserId()));
	}
	
	@Test
	void testValidProductId() throws InvalidProductDetailsException {
		Assertions.assertTrue(orderValidator().validateProductId(validOrder().getProductId()));
	}
	
	@Test
	void testValidTotalPrice() throws InvalidProductDetailsException {
		Assertions.assertTrue(orderValidator().validateTotalPrice(validOrder().getTotalPrice()));
	}
	
	
	// Invalid Order Test Cases
	static Order invalidOrder() {
		Order invalidOrder = null;
		return invalidOrder;
	}
	
	@Test
	void testInvalidOrder() throws InvalidProductDetailsException, InvalidUserException {
		try {
			orderValidator().validateOrder(invalidOrder());
			Assertions.fail("Test Invalid Order Method is Failded");
		}catch(InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_ORDER, ex.getMessage());
		}
	}
	
	@Test
	void testInvalidUserId() {
		try {
			orderValidator().validateUserId(0);
			Assertions.fail("Test Invalid User Id Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_ID, ex.getMessage());
		}
	}
	
	@Test
	void testInvalidProductId() {
		try {
			orderValidator().validateProductId(0);
			Assertions.fail("Test Invalid Product Id Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
	}
	
	@Test
	void testInvalidTotalPrice() {
		try {
			orderValidator().validateTotalPrice(0);
			Assertions.fail("Test Invalid Total Price Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_PRICE, ex.getMessage());
		}
	}
	
}
