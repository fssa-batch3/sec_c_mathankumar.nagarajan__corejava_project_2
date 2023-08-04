package com.fssa.spartansmt.validator;

import com.fssa.spartansmt.errors.OrderValidatorErrors;
import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.exception.InvalidProductDetailsException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.Order;

public class OrderValidator {

	public boolean validateOrder(Order order) throws InvalidProductDetailsException, InvalidUserException, InvalidOrderDetailsException {
		
		if(order == null) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_ORDER);
		}
		
		OrderValidator ov = new OrderValidator();
		ov.validateProductId(order.getProductId());
		ov.validateTotalPrice(order.getTotalPrice());
		ov.validateUserId(order.getUserId());
		
		return true; 
		
	}
	
	public boolean validateUserId(int userId) throws InvalidUserException {
		
		if(userId <= 0) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_ID);
		}
		return true;
		
	}

	public boolean validateTotalPrice(int price) throws InvalidProductDetailsException {
		if(price <= 0) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_PRICE);
		}
		return true;
	}
	
	public boolean validateProductId(int productId) throws InvalidProductDetailsException {
		if(productId <= 0) {
			throw new InvalidProductDetailsException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}
		return true;
	}

}
