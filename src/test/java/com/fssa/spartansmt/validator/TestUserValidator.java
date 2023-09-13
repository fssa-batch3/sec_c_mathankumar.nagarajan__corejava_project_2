package com.fssa.spartansmt.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;

class TestUserValidator {
	
	static User validUser() {
		User u1 = new User();
		u1.setUserId(1);
		u1.setFirstName("Mathankumar");
		u1.setLastName("G N");
		u1.setEmail("kumarmadhan432@gmail.com");
		u1.setPhoneNumber(8940169934l);
		u1.setPassword("Mathan@123");
		return u1;
	}
	
	static User invalidUser() {
		User u1 = new User();
		u1.setFirstName(null);
		u1.setLastName(null);
		u1.setEmail(null);
		u1.setPassword(null);
		u1.setPhoneNumber(0);
		return u1;
	}
	
	static User invalidEmptyUser() {
		User u1 = new User();
		u1.setFirstName("");
		u1.setLastName("");
		u1.setEmail("");
		u1.setPassword("");
		return u1;
	}
	
	static UserValidator userValidator() {
		UserValidator uv = new UserValidator();
		return uv;
	}
	
	@Test
	void testValidUser() throws InvalidUserException {
		Assertions.assertTrue(userValidator().validate(validUser()));
	}
	
	@Test
	void testValidFirstName() throws InvalidUserException {
		Assertions.assertTrue(userValidator().validateFirstName(validUser().getFirstName()));
	}

	@Test
	void testValidLastName() throws InvalidUserException {
		Assertions.assertTrue(userValidator().validateLastName(validUser().getLastName()));
	}
	
	@Test
	void testValidEmail() throws InvalidUserException {
		Assertions.assertTrue(userValidator().validateEmail(validUser().getEmail()));
	}
	
	@Test
	void testValidPhoneNumber() throws InvalidUserException {
		Assertions.assertTrue(userValidator().validatePhoneNumber(validUser().getPhoneNumber()));
	}

	@Test
	void testValidPassword() throws InvalidUserException {
		Assertions.assertTrue(userValidator().validatePassword(validUser().getPassword()));
	}
	
	@Test
	void testValidUserId() throws InvalidUserException {
		
		Assertions.assertTrue(userValidator().validateId(validUser().getUserId()));
	}
	
	
	// Invalid Input Test Cases
	
	@Test
	void testInvalidUser() {
		try {
			userValidator().validate(null);
			Assertions.fail("Test Invalid User Method is Failded");
			
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_NULL, ex.getMessage());
		}
	}

	
	@Test
	void testInvalidFirstNameNull() {
		try {
			userValidator().validateFirstName(invalidUser().getFirstName());
			Assertions.fail("Test Invalid First Name Null Method is Failded");
			
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_FIRST_NAME, ex.getMessage());
		}
	}

	
	@Test
	void testInvalidLastNameNull() {
		try {
			userValidator().validateLastName(invalidUser().getLastName());
			Assertions.fail("Test Invalid Last Name Null Method is Failded");
			
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_LAST_NAME, ex.getMessage());
		}
	}

	@Test
	void testInvalidEmailNull() {
		try {
			userValidator().validateEmail(invalidUser().getEmail());
			Assertions.fail("Test Invalid Email Null Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_EMAIL, ex.getMessage());
		}
	}
	
	@Test
	void testInvalidPhoneNumberNull() {
		try {
			userValidator().validatePhoneNumber(invalidUser().getPhoneNumber());
			Assertions.fail("Test Invalid Phone Number Null Method is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}
	}
	
	@Test
	void testInvalidPasswordNull() {
		try {
			userValidator().validatePassword(invalidUser().getPassword());
			Assertions.fail("Test Invalid Password Null Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_PASSWORD, ex.getMessage());;
		}
	}
	
	// Invalid Empty input's
	
	@Test
	void testInvalidFirstNameEmpty() {
		try {
			userValidator().validateFirstName(invalidEmptyUser().getFirstName());
			Assertions.fail("Test Invalid First Name Empty Method is Failded");
			
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_FIRST_NAME, ex.getMessage());
		}
	}

	
	@Test
	void testInvalidLastNameEmpty() {
		try {
			userValidator().validateLastName(invalidEmptyUser().getLastName());
			Assertions.fail("Test Invalid Last Name Empty Method is Failded");
			
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_LAST_NAME, ex.getMessage());
		}
	}

	@Test
	void testInvalidEmailEmpty() {
		try {
			userValidator().validateEmail(invalidEmptyUser().getEmail());
			Assertions.fail("Test Invalid Email Empty Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_EMAIL, ex.getMessage());
		}
	}
	
	@Test
	void testInvalidPhoneNumberEmpty() {
		try {
			userValidator().validatePhoneNumber(invalidEmptyUser().getPhoneNumber());
			Assertions.fail("Test Invalid Phone Number Empty Method is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}
	}
	
	@Test
	void testInvalidPasswordEmpty() {
		try {
			userValidator().validatePassword(invalidEmptyUser().getPassword());
			Assertions.fail("Test Invalid Password Empty Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_PASSWORD, ex.getMessage());;
		}
	}
	
	
	// Invalid Email Address
	
	@Test
	void testInvalidEmail() {
		try {
			userValidator().validateEmail("Mathan");
			Assertions.fail("Test Invalid Email Method is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_EMAIL, ex.getMessage());
		}
	}
	
	// Invalid Password
	
	@Test
	void testInvalidPassword() {
		try {
			userValidator().validatePassword("Mathan");
			Assertions.fail("Test Invalid Password Method is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_PASSWORD, ex.getMessage());
		}
	}
	
	
	// Invalid User ID
	@Test
	void testInvalidId() {
		try {
			userValidator().validateId(-20);
			Assertions.fail("Test Invalid ID Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_ID, ex.getMessage());
		}
	}
	
	// Invalid User Phone Number
	@Test
	void testInvaliPhoneNumber() {
		try {
			userValidator().validatePhoneNumber(1234567890);
			Assertions.fail("Test Invalid Phone Number Method Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}
	}
	
	// invalid phone number length
	@Test
	void testInvaliPhoneNumberLength() {
		try {
			userValidator().validatePhoneNumber(123456780);
			Assertions.fail("Test Invalid Phone Number Method Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}
	}
}
