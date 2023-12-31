package com.fssa.spartansmt.validator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import com.fssa.spartansmt.constants.UserConstants;
import com.fssa.spartansmt.errors.UserValidatorErrors;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;
import com.fssa.spartansmt.regexpattern.UserRegexPattern;

/* 
 * @author MathankumarNagarajan
 */

public class UserValidator {

	/*
	 * Validate Method Should Validate The Full User Details
	 */
	public boolean validate(User user) throws InvalidUserException {

		/*
		 * If the User Object is Null It should the Exception.
		 */
		if (user == null) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_NULL);
		}

		/*
		 * Invoked Validate First Name Method
		 */
		validateFirstName(user.getFirstName());

		/*
		 * Invoked Validate Last Name Method
		 */
		validateLastName(user.getLastName());

		/*
		 * Invoked Validate Email Method
		 */
		validateEmail(user.getEmail());

		/*
		 * Validate Phone Number Method
		 */
		validatePhoneNumber(user.getPhoneNumber());

		/*
		 * Validate Password Method
		 */
		validatePassword(user.getPassword());
		
		
		/*
		 * Here is converting the user given password to hash password and returning the
		 * hash password to the validate method. That method will set the hash password
		 * to the same user object.
		 */
		user.setPassword(hashPassword(user.getPassword()));

		/*
		 * If the all Method's returned true the validate should return true. Otherwise
		 * that method throw the Exception.
		 */

		return true;

	}

	/*
	 * This method is used to validate the User Address Details It is used to 
	 * the Order Module to validate Shipping Address.
	 */
	public boolean validateAddressDetails(User user) throws InvalidUserException {
		
		if(user == null) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_NULL);
		}
		
		validateAddress(user.getAddress());
		
		validateCountry(user.getCountry());
		
		validateState(user.getState());
		
		validateZipCode(user.getZipCode());
		
		return true;
		
	}
	
	public boolean validateUpdateUserObj(User user) throws InvalidUserException {
		
		/*
		 * If the User Object is Null It should the Exception.
		 */
		if (user == null) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_NULL);
		}

		/*
		 * Invoked Validate First Name Method
		 */
		validateFirstName(user.getFirstName());

		/*
		 * Invoked Validate Last Name Method
		 */
		validateLastName(user.getLastName());

		/*
		 * Invoked Validate Email Method
		 */
		validateEmail(user.getEmail());

		/*
		 * Validate Phone Number Method
		 */
		validatePhoneNumber(user.getPhoneNumber());
		
		return true;
		
	}
	
	
	/*
	 * This Method Validate the User First Name
	 */
	public boolean validateFirstName(String firstName) throws InvalidUserException {

		/*
		 * This Method receive First Name as a String. If the String is null or Empty it
		 * will throw the Exception. Otherwise It will return true.
		 */
		if (firstName == null || "".equals(firstName.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_FIRST_NAME);
		}

		return true;

	}

	/*
	 * This Method is Validate The User Last Name.
	 */
	public boolean validateLastName(String lastName) throws InvalidUserException {

		/*
		 * This Method receive Last Name as a String. If the String is null or Empty it
		 * will throw the Exception. Otherwise It will return true.
		 */
		if (lastName == null || "".equals(lastName.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_LAST_NAME);
		}

		return true;

	}

	/*
	 * This Method is Validate The User Email.
	 */
	public boolean validateEmail(String email) throws InvalidUserException {

		/*
		 * This Method receive Email Address as a String. If the String is null or Empty
		 * it will throw the Exception. Otherwise It will Check Next Conditions.
		 */
		if (email == null || "".equals(email.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_EMAIL);
		}

		/*
		 * Here It will Match the regex Pattern and User Given Email Address
		 */
		boolean isMatch = Pattern.matches(UserRegexPattern.REGEX_EMAIL, email);

		/*
		 * The Matches returned false below Exception Will throw. Otherwise this method
		 * return true.
		 */

		if (!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_EMAIL);
		}

		return true;

	}

	/*
	 * This Method Is Validate The User Mobile Number
	 */
	public boolean validatePhoneNumber(long phNumber) throws InvalidUserException {

		String phoneNumber = Long.toString(phNumber);

		/*
		 * This the receive a mobile number as a String. If the Mobile Number is Null,
		 * Empty or the Mobile Number minimum have 10 digit number it should not have.
		 * It will throw the Exception. Otherwise it will check next Conditions.
		 */
		if (phoneNumber == null || "".equals(phoneNumber.trim()) || phoneNumber.length() < UserConstants.MIN_LENGTH) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PHONE_NUMBER);
		}

		/*
		 * The Matches returned false below Exception will throw. Otherwise this Method
		 * will return true.
		 */
		boolean isMatch = Pattern.matches(UserRegexPattern.REGEX_MOBILE_NUM, phoneNumber);

		if (!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PHONE_NUMBER);
		}

		return true;

	}

	/*
	 * This Method Is Validate The User Given Password
	 */
	public boolean validatePassword(String password) throws InvalidUserException {

		/*
		 * This Method received the Password as a String. If the String Value Is Null or
		 * Empty It will throw the Exception. Otherwise it will check next conditions.
		 */
		if (password == null || "".equals(password.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PASSWORD);
		}

		/*
		 * The Matches returned False below Exception will throw. Otherwise this Method
		 * will return true.
		 */
		boolean isMatch = Pattern.matches(UserRegexPattern.REGEX_PASS_PATTERN, password);

		if (!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_PASSWORD);
		}
				
		return true;

	}
	
	public static String hashPassword(String password) throws InvalidUserException {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			// Convert the byte array to a hexadecimal string
			StringBuilder sb = new StringBuilder();
			for (byte b : hashedBytes) {
				sb.append(String.format("%02x", b));
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new InvalidUserException(e.getMessage());
		}
	}

	public boolean validateId(int id) throws InvalidUserException {

		/*
		 * If the User ID have zero or Less then zero The Exception will throw.
		 * Otherwise It will true.
		 */
		if (id <= UserConstants.INVALID_USER_ID) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_USER_ID);
		}

		return true;
	}

	public boolean validateAddress(String address) throws InvalidUserException {

		if (address == null || "".equals(address.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_ADDRESS);
		}

		return true;

	}

	public boolean validateCountry(String country) throws InvalidUserException {

		if (country == null || "".equals(country.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_COUNTRY);
		}
		
		boolean isMatch = Pattern.matches(UserRegexPattern.REGEX_STRING_PATTERN, country);

		if (!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_COUNTRY);
		}

		return true;

	}
	
	public boolean validateState(String state) throws InvalidUserException {

		if (state == null || "".equals(state.trim())) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_STATE);
		}
		
		boolean isMatch = Pattern.matches(UserRegexPattern.REGEX_STRING_PATTERN, state);

		if (!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_STATE);
		}

		return true;

	}
	
	public boolean validateZipCode(int zipCode) throws InvalidUserException {
		
		String strZipCode = Integer.toString(zipCode);
		System.out.println(strZipCode);
		
		if (strZipCode == null || "".equals(strZipCode.trim()) || strZipCode.length() < UserConstants.ZIP_CODE_LENGTH) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_ZIP_CODE);
		}

		
		boolean isMatch = Pattern.matches(UserRegexPattern.REGEX_ZIPCODE_PATTERN, strZipCode);

		if (!isMatch) {
			throw new InvalidUserException(UserValidatorErrors.INVALID_ZIP_CODE);
		}

		return true;
				
		
	}

	
	

}
