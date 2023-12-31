package com.fssa.spartansmt.regexpattern;

public class UserRegexPattern {
	private UserRegexPattern() {
		// private constructor
	}
	public static final String REGEX_EMAIL = "^[a-z0-9][a-zA-Z0-9._%+-]*@[a-z0-9.-]+\\.[a-z]{2,}$";
	
	public static final String REGEX_MOBILE_NUM = "[6789][0-9]{9}";
	
	public static final String REGEX_PASS_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";

	public static final String REGEX_STRING_PATTERN = "^[A-Za-z ]{2,}$";
	
	public static final String REGEX_ZIPCODE_PATTERN = "^[0-9]{6}$";
	
}
