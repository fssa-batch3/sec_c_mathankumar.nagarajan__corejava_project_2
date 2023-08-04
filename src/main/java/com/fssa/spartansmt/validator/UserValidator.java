package com.fssa.spartansmt.validator;

import java.util.regex.Pattern;

import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;

// TODO - Write Comments

public class UserValidator {
	
	public boolean validate(User user) throws InvalidUserException {
		
		if(user == null) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_NULL);
		}
		
		validateFirstName(user.getFirstName());
		validateLastName(user.getLastName());
		validateEmail(user.getEmail());
		validatePhoneNumber(user.getPhoneNumber());
		validatePassword(user.getPassword());
		
		return true;
		
	}

	public boolean validateFirstName(String firstName) throws InvalidUserException {

		if (firstName == null || "".equals(firstName.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_FIRST_NAME);
		}

		return true;

	}

	public boolean validateLastName(String lastName) throws InvalidUserException {

		if (lastName == null || "".equals(lastName.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_LAST_NAME);
		}

		return true;

	}
	
	public boolean validateEmail(String email) throws InvalidUserException {
		
		if(email == null || "".equals(email)) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_EMAIL);
		}
		
		String regex = "^[a-z0-9][a-zA-Z0-9._%+-]*@[a-z0-9.-]+\\.[a-z]{2,}$";
		
		boolean isMatch = Pattern.matches(regex, email);
		
		if(!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_EMAIL);
		}
		
		return true;
		
	}
	
	
	public boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
		
		if( phoneNumber == null || "".equals(phoneNumber.trim()) || phoneNumber.length() < 10 ) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PHONE_NUMBER);
		}
		
		String regex = "[6789][0-9]{9}";
		
		boolean isMatch = Pattern.matches(regex, phoneNumber);
		
		if(!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PHONE_NUMBER);
		}
		
		return true;
		
	}
	
	
	public boolean validatePassword(String password) throws InvalidUserException {
		
		if(password == null || "".equals(password.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PASSWORD);
		}
		
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";
		
		boolean isMatch = Pattern.matches(regex, password);
		
		if(!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PASSWORD);
		}
		
		return true;
		
	}
	
	public boolean validateId(int id) throws InvalidUserException {
		
		if(id <= 0) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_ID);
		}
		
		return true;
	}

	
}
