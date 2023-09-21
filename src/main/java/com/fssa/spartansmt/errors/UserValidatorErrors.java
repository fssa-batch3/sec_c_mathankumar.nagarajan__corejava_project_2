package com.fssa.spartansmt.errors;

public class UserValidatorErrors {
	private UserValidatorErrors() {
//		private constructor
	}
	public static final String INVALID_USER_NULL = "User Object Can't be Null.";
	
	public static final String INVALID_USER_FIRST_NAME = "User firstname can't be null or empty.";
	
	public static final String INVALID_USER_LAST_NAME = "User lastname can't be null or Empty.";
	
	public static final String INVALID_USER_EMAIL = "Invalid User Email Address.";
	
	public static final String INVALID_USER_PHONE_NUMBER = "Invalid User Phone Number.";
	
	public static final String INVALID_USER_PASSWORD = "Invalid User Password.";
	
	public static final String INVALID_USER_ID = "Invalid User Id."; 
	
	public static final String INVALID_MISMATCHED_PASSWORD = "create password and confirm password should be equal";

	public static final String INVALID_ADDRESS = "Address Can't be Null or Empty";
	
	public static final String INVALID_COUNTRY = "Country Can't be Null, Empty or It shour have only Alphabets";
	
	public static final String INVALID_STATE = "State Can't be Null, Empty or It shour have only Alphabets";
	
	public static final String INVALID_ZIP_CODE = "Zip Code Can't be empty or It will allow only Numbers";
	
}
