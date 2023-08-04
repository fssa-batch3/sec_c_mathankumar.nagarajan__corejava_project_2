package com.fssa.spartansmt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;

public class TestUserService {
	
	public static User user() {
		User u = new User();
		u.setUserId(1);
		u.setEmail("kumarmadhan432@gmail.com");
		u.setFirstName("Kumarmathan");
		u.setLastName("GN");
		u.setPassword("Demo@123");
		u.setPhoneNumber("8940169934");
		return u;
	}
	
	public static UserService userService() {
		UserService us = new UserService();
		return us;
	}
	
	
	@Test
	public void testValidAddUser() throws InvalidUserException, DAOException {
		Assertions.assertTrue(userService().addUser(user()));
	}
	
	@Test
	public void testValidUpdateUser() throws InvalidUserException, DAOException {
		Assertions.assertTrue(userService().updateUser(user()));
	}
	
	@Test
	public void testValidGetAllUserDetails() throws DAOException {
		Assertions.assertTrue(userService().getAllUserDetails());
	}
	

}
