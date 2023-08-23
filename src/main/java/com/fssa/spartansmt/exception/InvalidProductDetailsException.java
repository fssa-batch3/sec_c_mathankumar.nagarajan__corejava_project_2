package com.fssa.spartansmt.exception;

/*
 * @author MathankumarNagarajan
 * 
 * A class which holds the InvalidProductDetailsException.
 * It has the InvalidProductDatailsException it has get the
 * messages through the parameter and it will send to 
 * the super class (Exception class).
 */
public class InvalidProductDetailsException extends Exception {
	
	private static final long serialVersionUID = 2L;

	/*
	 * Below constructor will get the message through the parameter
	 * and that message will send to the super class.
	 */
	public InvalidProductDetailsException(String msg) {
		super(msg);
	}


}
