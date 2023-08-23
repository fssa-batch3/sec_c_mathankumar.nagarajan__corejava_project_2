package com.fssa.spartansmt.exception;

/*
 * @author MathankumarNagarajan
 * 
 * A class which holds the Exception
 * It has method that method will get the message
 * through the parameter and it will send the super class(Exception class).
 */

public class InvalidStoreDetailsException extends Exception {

	private static final long serialVersionUID = 2L;

	/*
	 * Create a method it will get the messages through
	 * the parameter and it will send to the super class.
	 * (Exception class)
	 */
	public InvalidStoreDetailsException(String msg) {
		super(msg);
	}
}