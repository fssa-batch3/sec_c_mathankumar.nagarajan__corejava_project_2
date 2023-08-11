package com.fssa.spartansmt.validator;

import com.fssa.spartansmt.constants.UserConstants;
import com.fssa.spartansmt.errors.OrderValidatorErrors;
import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.model.Order;

public class OrderValidator {
	
	/*
	 * Validate Order Method is Validate The full Order Object. 
	 */
	public static boolean validateOrder(Order order) throws InvalidOrderDetailsException {
		
		/*
		 * Here is the order object is null it will throw the Exception
		 */
		if(order == null) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_ORDER);
		}
		
		/*
		 * All the Above Methods passed or returned true below return code will execute
		 */
		return true;
		
	}
	
	public static boolean validateUserId(int userId) throws InvalidOrderDetailsException {
		  
		/*
		 * Here is validating a User Id Is Valid or invalid
		 * If the User id Is Zero or less then Zero it will throw
		 * the Exception otherwise it will true.
		 */
		if(userId <= UserConstants.INVALID_USER_ID) {
			throw new InvalidOrderDetailsException(UserValidatorErrors.INVALID_USER_ID);
		}
		
		return true;
		
	}
	
	/*
	 * Below Method is Validate The Payment Status Of Order Object
	 */
	public static boolean validatePaymentStatus(String status) throws InvalidOrderDetailsException {
		
		/*
		 * If the Payment Status Is Null Or Empty It will throw the Exception.
		 * Otherwise It will return true.
		 */
		if(status == null || "".equals(status.trim())){
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_PAYMETN_STATUS);
		}
		
		
		
		
		return true;
		
	}
	
	

}
