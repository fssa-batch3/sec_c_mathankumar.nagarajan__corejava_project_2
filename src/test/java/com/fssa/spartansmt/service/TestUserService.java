package com.fssa.spartansmt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.exception.ServiceException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.User;

class TestUserService {
	
	static User user() {
		User u = new User();
		u.setUserId(1);
		u.setEmail("mathan@gmail.com");
		u.setFirstName("Mathankumar");
		u.setLastName("GN");
		u.setPassword("Mathan@123");
		u.setPhoneNumber(8940169934l);
		u.setAddress("12 chennai");
		u.setCountry("India");
		u.setState("Chennai");
		u.setZipCode(623707);
		return u;
	}
	
	static UserService userService() {
		UserService us = new UserService();
		return us;
	}
	
	
	@Test
	void testValidAddUser() throws InvalidUserException, DAOException, ServiceException {
		Assertions.assertTrue(userService().addUser(user()));
	}
	
	@Test
	void testValidUpdateUser() throws InvalidUserException, DAOException {
		Assertions.assertTrue(userService().updateUser(user()));
	}
	
	@Test
	void testValidGetAllUserDetails() throws DAOException {
		Assertions.assertTrue(userService().getAllUserDetails());
	}
	
	@Test
	void testValidGetUserByEmail() throws DAOException, InvalidUserException, ServiceException {
		User user = (userService().getUserByEmail(user().getEmail()));
		Logger.info(user);
	}

	

}
