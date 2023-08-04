package com.fssa.spartansmt.exception;

public class InvalidProductDetailsException extends Exception {
	
	private static final long serialVersionUID = 2L;

	public InvalidProductDetailsException(String msg) {
		super(msg);
	}

	public InvalidProductDetailsException(Throwable te) {
		super(te);
	}

	public InvalidProductDetailsException(String msg, Throwable te) {
		super(msg, te);
	}

}
