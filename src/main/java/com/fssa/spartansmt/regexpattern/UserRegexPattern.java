package com.fssa.spartansmt.regexpattern;

public interface UserRegexPattern {
	
	String REGEX_EMAIL = "^[a-z0-9][a-zA-Z0-9._%+-]*@[a-z0-9.-]+\\\\.[a-z]{2,}$";
	
	String REGEX_MOBILE_NUM = "[6789][0-9]{9}";
	
	String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";

}
