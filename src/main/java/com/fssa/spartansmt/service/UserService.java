package com.fssa.spartansmt.service;

import com.fssa.spartansmt.dao.UserDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;
import com.fssa.spartansmt.validator.UserValidator;

public class UserService {
	
	public static UserValidator userValidator() {
		UserValidator uv = new UserValidator();
		return uv;
	}
	
	public static UserDao userDao() {
		UserDao ud = new UserDao();
		return ud;
	}
	
	public boolean addUser(User user) throws InvalidUserException, DAOException {
		
		if(userValidator().validate(user)) {
			userDao().addUser(user);
		}
		return true;
		
	}
	
	public boolean updateUser(User user) throws InvalidUserException, DAOException {
		
		if(userValidator().validate(user)) {
			userDao().updateUser(user);
		}
		return true;
		
	}
	
	
	public boolean getAllUserDetails() throws DAOException {
		
		userDao().getAllUserDetails();
		return true;
	}
	
	
//	public static void main(String[] args) throws InvalidUserException, DAOException {
//		
//		UserService us = new UserService();
//		
//		User u = new User();
//		u.setUserId(1);
//		u.setEmail("kumarmadhan432@gmail.com");
//		u.setFirstName("Kumarmathan");
//		u.setLastName("GN");
//		u.setPassword("Demo@123");
//		u.setPhoneNumber("8940169934");
//		
//		
//		us.getAllUserDetails();
//		
//	}

}
