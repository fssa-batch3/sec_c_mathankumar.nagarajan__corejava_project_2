package com.fssa.spartansmt.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;

class TestUserDao {
	
	// Valid User Details 
	static User user() {
		
		User ud = new User();
		ud.setUserId(30);
		ud.setFirstName("Mathan");
		ud.setLastName("GN");
		ud.setPhoneNumber(8940169934l);
		ud.setEmail("junittest@gmail.com");
		ud.setPassword("Junit@123");
		return ud;
		
	}
	
	// Invalid User Details
	static User invalidUser() {
		
		User ud = new User();
		ud.setUserId(0);
		ud.setFirstName(null);
		ud.setLastName(null);
		ud.setPhoneNumber(0);
		ud.setEmail(null);
		ud.setPassword(null);
		return ud;
		
	}
	
	// Creating a UserDao Class Object.
	static UserDao userDao() {
		UserDao ud = new UserDao();
		return ud;
	}
	
	// Valid input Test Cases
	@Test
	void testValidAddUser() throws DAOException {
		Assertions.assertTrue(userDao().addUser(user()));
	}
	
	@Test
	void testValidUpdateUser() throws DAOException, InvalidUserException{
		Assertions.assertTrue(userDao().updateUser(user()));
	}
	
	@Test
	void testValidGetAllUserDetails() throws DAOException {
		Assertions.assertTrue(userDao().getAllUserDetails());
	}
	

	// Invalid Input Test Cases
	@Test
	void testInvalidAddUser() {
		
		try {
			userDao().addUser(invalidUser());
			Assertions.fail("Test Invalid Add User Method Is Failded");
		}catch(DAOException ex) {
			Assertions.assertEquals("Add User Method is Failded", ex.getMessage());
		}
		
	}
	
	@Test
	void testInvalidupdateUser() throws InvalidUserException {
		try {
			User ud = new User();
			ud.setUserId(5);
			userDao().updateUser(ud);
			Assertions.fail("Test Invalid Update User Method Is Failed");
		}catch(DAOException ex) {
			Assertions.assertEquals("Update User Details Method Is Failded", ex.getMessage());
		}
	}
	
	@Test
	void testInvalidUserId() throws DAOException {
		try {
			userDao().updateUser(invalidUser());
			Assertions.fail("Test Invalid User ID Method Is Failded");
		}catch(InvalidUserException ex) {
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID, ex.getMessage());
		}
	}
	

}
