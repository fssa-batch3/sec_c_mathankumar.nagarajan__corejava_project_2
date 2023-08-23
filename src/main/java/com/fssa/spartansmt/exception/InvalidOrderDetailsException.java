package com.fssa.spartansmt.exception;

/*
 * @author MathankumarNagarajan
 * 
 * It has the InvalidOrderDetailsExceptin Method.
 * That method will get the Msg through the parameter
 * and that msg will send to the super class(Exception class).
 */
public class InvalidOrderDetailsException extends Exception {
	
	private static final long serialVersionUID = 2L;

	public InvalidOrderDetailsException(String msg) {
		super(msg);
	}

}
