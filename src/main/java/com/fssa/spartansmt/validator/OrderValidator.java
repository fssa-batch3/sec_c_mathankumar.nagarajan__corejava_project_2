package com.fssa.spartansmt.validator;

import java.time.LocalDate;
import java.util.List;

import com.fssa.spartansmt.constants.OrderConstants;
import com.fssa.spartansmt.constants.UserConstants;
import com.fssa.spartansmt.errors.OrderValidatorErrors;
import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.model.Order;
import com.fssa.spartansmt.model.OrderedProduct;

/*
 * A class which holds the validation method for the Order model Object.
 * It has method to validate the order model object.
 * 
 * @author MathankumarNagarajan
 */

public class OrderValidator {
 
	/*
	 * Validate Order Method is Validate The full Order Object.
	 */
	public boolean validateOrder(Order order) throws InvalidOrderDetailsException {

		/*
		 * Here is the order object is null it will throw the Exception
		 */
		if (order == null) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_ORDER);
		}

		// Invoked Validate User Id Method
		validateUserId(order.getUserId());

		// Invoked Validate Total Price Method
		validateTotalPrice(order.getTotalPrice());

		// Invoked Validate Payment Status Method
		validatePaymentStatus(order.getPaymentOption());

		// Invoked Validate Order Date Method
		validateOrderDate(order.getOrderDate());

		// Invoked Validate Ordered Product Method
		validateOrderdedProducts(order.getOrderedProducts());

		/*
		 * All the Above Methods passed or returned true below return code will execute
		 */
		return true;

	}

	/*
	 * Validate Order User Id Method
	 */
	public static boolean validateUserId(int userId) throws InvalidOrderDetailsException {

		/*
		 * Here is validating a User Id Is Valid or invalid If the User id Is Zero or
		 * less then Zero it will throw the Exception otherwise it will true.
		 */
		if (userId <= UserConstants.INVALID_USER_ID) {
			throw new InvalidOrderDetailsException(UserValidatorErrors.INVALID_USER_ID);
		}

		// Return True Statement
		return true;

	}

	/*
	 * Validate Total Price Method
	 */
	public static boolean validateTotalPrice(double price) throws InvalidOrderDetailsException {

		/*
		 * Here is validating the total order price if the price is zero or less then
		 * zero bellow if statement will throw the Exception otherwise it will 
		 * return true.
		 */
		if (price <= OrderConstants.INVALID_TOTAL_PRICE) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.ORDER_TOTAL_PRICE);
		}

		// Return True Statement
		return true;

	}

	/*
	 * Validate Order Payment Status
	 */
	public static boolean validatePaymentStatus(String paymentStatus) throws InvalidOrderDetailsException {

		/*
		 * Here is Validating the payment status if the payment status is null
		 * or Empty bellow if statement will throw the Exception.
		 * Otherwise it will return true.
		 */
		if (paymentStatus == null || "".equals(paymentStatus.trim())) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_PAYMENT_STATUS);
		}
		
		// Return True Statement
		return true;

	}

	/*
	 * Validate Ordered Date
	 */
	public static boolean validateOrderDate(LocalDate today) throws InvalidOrderDetailsException {

		/*
		 * Check if the date is null
		 */
		if (today == null) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_LOCALDATE);
		}

		/*
		 * Check if the date is not equal to the current date it will throw the
		 * Exception. (i.e., it should be present)
		 */
		if (!today.isEqual(LocalDate.now())) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_LOCALDATE);
		}

		// Return True Statement
		return true;

	}

	/*
	 * Validating the list of OrderedProduct Object 
	 */
	public static boolean validateOrderdedProducts(List<OrderedProduct> orderedProductList)
			throws InvalidOrderDetailsException {

		/*
		 * Here Is the Ordered Product Object Is Null Bellow if statement will 
		 * throw the Exception. Otherwise it will execute next codes.
		 */
		if (orderedProductList == null) {
			throw new InvalidOrderDetailsException(OrderValidatorErrors.INVALID_ORDERED_PRODUCT);
		}

		/*
		 * Through the Parameter this method get the list of ordered product.
		 * Bellow forEach it will get one by one object to validate the
		 * OrderedProduct Object Using OrderedProductValidator Class.
		 */
		for (OrderedProduct e : orderedProductList) {

			try {
				OrderedProductValidator orderedProductValidator = new OrderedProductValidator();
				orderedProductValidator.validateOrderedProduct(e);
			} catch (InvalidOrderDetailsException ex) {
				/*
				 * If any object details is invalid OrderedProductValidator 
				 * Class Method's will throwing the exception.
				 * That Exception will catch by this method.
				 * And then this method will the get the message and
				 * throw Exception.
				 */
				throw new InvalidOrderDetailsException(ex.getMessage());
			}

		}

		// Return True Statement
		return true;

	}

}
