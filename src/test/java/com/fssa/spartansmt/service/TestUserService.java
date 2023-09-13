package com.fssa.spartansmt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.User;

class TestUserService {
	
	static User user() {
		User u = new User();
		u.setUserId(1);
		u.setEmail("mathan@gmail.com");
		u.setFirstName("Kumarmathan");
		u.setLastName("GN");
		u.setPassword("Demo@123");
		u.setPhoneNumber(8940169934l);
		return u;
	}
	
	static UserService userService() {
		UserService us = new UserService();
		return us;
	}
	
	
	@Test
	void testValidAddUser() throws InvalidUserException, DAOException {
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
	void testValidGetUserByEmail() throws DAOException, InvalidUserException {
		User user = (userService().getUserByEmail(user().getEmail()));
		Logger.info(user);
	}
	

}
