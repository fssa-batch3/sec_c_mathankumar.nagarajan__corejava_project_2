package com.fssa.spartansmt.regexpattern;

public interface UserRegexPattern {
	
	final String REGEX_EMAIL = "^[a-z0-9][a-zA-Z0-9._%+-]*@[a-z0-9.-]+\\.[a-z]{2,}$";
	
	final String REGEX_MOBILE_NUM = "[6789][0-9]{9}";
	
	final String REGEX_PASS_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";

}
