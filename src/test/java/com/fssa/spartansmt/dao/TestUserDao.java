package com.fssa.spartansmt.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;

public class TestUserDao {
	
	// Valid User Details 
	public static User user() {
		
		User ud = new User();
		ud.setUserId(2);
		ud.setFirstName("Mathankumar");
		ud.setLastName("GN");
		ud.setPhoneNumber("8940169934");
		ud.setEmail("junittest@gmail.com");
		ud.setPassword("Junit@123");
		return ud;
		
	}
	
	// Invalid User Details
	public static User invalidUser() {
		
		User ud = new User();
		ud.setUserId(0);
		ud.setFirstName(null);
		ud.setLastName(null);
		ud.setPhoneNumber(null);
		ud.setEmail(null);
		ud.setPassword(null);
		return ud;
		
	}
	
	// Creating a UserDao Class Object.
	public static UserDao userDao() {
		UserDao ud = new UserDao();
		return ud;
	}
	
	// Valid input Test Cases
	@Test
	public void testValidAddUser() throws DAOException {
		Assertions.assertTrue(userDao().addUser(user()));
	}
	
	@Test
	public void testValidUpdateUser() throws DAOException, InvalidUserException{
		Assertions.assertTrue(userDao().updateUser(user()));
	}
	
	@Test
	public void testValidGetAllUserDetails() throws DAOException {
		Assertions.assertTrue(userDao().getAllUserDetails());
	}
	

	// Invalid Input Test Cases
	@Test
	public void testInvalidAddUser() {
		
		try {
			userDao().addUser(invalidUser());
			Assertions.fail("Test Invalid Add User Method Is Failded");
		}catch(DAOException ex) {
			Assertions.assertEquals("Add User Method is Failded", ex.getMessage());
		}
		
	}
	
	@Test
	public void testInvalidupdateUser() throws InvalidUserException {
		try {
			User ud = new User();
			ud.setUserId(1);
			userDao().updateUser(ud);
			Assertions.fail("Test Invalid Update User Method Is Failed");
		}catch(DAOException ex) {
			Assertions.assertEquals("Update User Details Method Is Failded", ex.getMessage());
		}
	}
	
	@Test
	public void testInvalidUserId() throws DAOException {
		try {
			userDao().updateUser(invalidUser());
			Assertions.fail("Test Invalid User ID Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
	}
	

}
