package com.fssa.spartansmt.exception;

public class DAOException extends Exception {


	private static final long serialVersionUID = 2L;

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable ex) {
		super(ex);
	}
}