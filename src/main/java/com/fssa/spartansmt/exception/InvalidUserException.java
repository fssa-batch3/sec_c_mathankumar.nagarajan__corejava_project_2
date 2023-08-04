package com.fssa.spartansmt.exception;

public class InvalidUserException extends Exception{
	
	private static final long serialVersionUID = 2L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable te) {
		super(te);
	}

	public InvalidUserException(String msg, Throwable te) {
		super(msg, te);
	}

}
