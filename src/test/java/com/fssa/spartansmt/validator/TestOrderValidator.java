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

public class TestOrderValidator {
	
	public static Order validOrder() {
		Order order = new Order(1, 1, 1999);
		return order;
	}

	public static OrderValidator orderValidator() {
		OrderValidator ov = new OrderValidator();
		return ov;
	}
	
	@Test
	public void testValidOrder() throws InvalidProductDetailsException, InvalidUserException, InvalidOrderDetailsException {
		Assertions.assertTrue(orderValidator().validateOrder(validOrder()));
	}
	
	@Test
	public void testValidUserId() throws InvalidUserException {
		Assertions.assertTrue(orderValidator().validateUserId(validOrder().getUserId()));
	}
	
	@Test
	public void testValidProductId() throws InvalidProductDetailsException {
		Assertions.assertTrue(orderValidator().validateProductId(validOrder().getProductId()));
	}
	
	@Test
	public void testValidTotalPrice() throws InvalidProductDetailsException {
		Assertions.assertTrue(orderValidator().validateTotalPrice(validOrder().getTotalPrice()));
	}
	
	
	// Invalid Order Test Cases
	public static Order invalidOrder() {
		Order invalidOrder = null;
		return invalidOrder;
	}
	
	@Test
	public void testInvalidOrder() throws InvalidProductDetailsException, InvalidUserException {
		try {
			orderValidator().validateOrder(invalidOrder());
			Assertions.fail("Test Invalid Order Method is Failded");
		}catch(InvalidOrderDetailsException ex) {
			Assertions.assertEquals(OrderValidatorErrors.INVALID_ORDER, ex.getMessage());
		}
	}
	
	@Test
	public void testInvalidUserId() {
		try {
			orderValidator().validateUserId(0);
			Assertions.fail("Test Invalid User Id Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_ID, ex.getMessage());
		}
	}
	
	@Test
	public void testInvalidProductId() {
		try {
			orderValidator().validateProductId(0);
			Assertions.fail("Test Invalid Product Id Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
	}
	
	@Test
	public void testInvalidTotalPrice() {
		try {
			orderValidator().validateTotalPrice(0);
			Assertions.fail("Test Invalid Total Price Method Is Failded");
		}catch(InvalidProductDetailsException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_PRICE, ex.getMessage());
		}
	}
	
}
