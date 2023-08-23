package com.fssa.spartansmt.errors;

/*
 * @author MathankumarNagarajan
 * 
 * An interface which holds the Error messages for order model object
 * It has Invalid Error messages as a String.
 */

public class OrderValidatorErrors {

	private OrderValidatorErrors() {
		// private constructor
	}

	// Invalid Order Message
	public static final String INVALID_ORDER = "Order Object Should be Not Null";

	// Static Payment Status
	public static final String STATIC_PAYMENT_STATUS = "NO";

	// Invalid Order Total Price
	public static final String ORDER_TOTAL_PRICE = "Order Total Price Can't Be Zero or Less Then Zero";

	// LocalDate Validation Error
	public static final String INVALID_LOCALDATE = "LocalDate Can't be null or Before Date or After Date";

	// Invalid Product Error Message
	public static final String INVALID_ORDERED_PRODUCT = "The Ordered Product Object Can't Be Null or Empty";
	
	// Invalid Product Quantity Error Message
	public static final String INVALID_PRODUCT_QUANTITY = "The Product Quantity Can't Zero or Less then Zero";
	
	// Invalid Order Id Error Message
	public static final String INVALID_ORDER_ID = "The Order ID Must Have Zero or More then Zero";
	
	// Invalid Payment Status Error Message
	public static final String INVALID_PAYMENT_STATUS = "The Payment Status Can't be null or Empty";
	
}
