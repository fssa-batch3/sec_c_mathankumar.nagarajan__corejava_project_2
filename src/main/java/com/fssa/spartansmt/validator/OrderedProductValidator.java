package com.fssa.spartansmt.validator;

import com.fssa.spartansmt.constants.OrderConstants;
import com.fssa.spartansmt.constants.ProductConstants;
import com.fssa.spartansmt.errors.OrderValidatorErrors;
import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.model.OrderedProduct;


/*
 * @author MathankumarNagarajan
 * 
 * A class which holds the method to validate the ordered product object.
 * It has methods to validate the ordered product model object.
 */

public class OrderedProductValidator {
	
	/* 
	 * This Method will Validate the full Ordered Product Object
	 */
	public boolean validateOrderedProduct(OrderedProduct orderedProduct) throws InvalidOrderDetailsException {
		
		/*
		 * if the Ordered Product object is null bellow code will throw
		 * the Exception. Otherwise it will check bellow invoked method's.
		 */
		if(orderedProduct == null) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_ORDERED_PRODUCT);
		}	
		
		// Invoked validate Product Id Method
		validateProductId(orderedProduct.getProductId());
		
		// Invoked validate quantity method
		validateQuantity(orderedProduct.getQuantity());
		
		// return statement
		return true;
		
	}
	
	
	/*
	 * This Method Validate Product Id 
	 */
	public static boolean validateProductId(int productId) throws InvalidOrderDetailsException {
		
		/*
		 * If the Product Id is Zero or less then Zero.
		 * It will throw the Exception. Otherwise this 
		 * method will return true.
		 */
		if(productId <= ProductConstants.INVALID_PRODUCT_ID) {
			throw new InvalidOrderDetailsException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}
		
		// return statement
		return true;
		
	}
	
	/*
	 * This Method Validate Ordered Product Quantity
	 */
	public static boolean validateQuantity(int quantity) throws InvalidOrderDetailsException {
		
		/*
		 * If the product quantity is zero or less zero this method
		 * will throw the Exception Otherwise It will return true.
		 */
		if(quantity <= OrderConstants.INVALID_PRODUCT_QUENTITY) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_PRODUCT_QUANTITY);
		}
		// return statement
		return true;
		
	}
	

}
