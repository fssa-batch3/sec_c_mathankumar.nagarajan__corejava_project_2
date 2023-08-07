package com.fssa.spartansmt.service;

import com.fssa.spartansmt.dao.UserDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.User;
import com.fssa.spartansmt.validator.UserValidator;

/*
 * @author MathankumarNagarajan
 * This codes will check the object that given by User
 * and then it will send to the validator if the validate Method is 
 * returned true. It will send to the Dao Layer that Method Will execute the query 
 * to add or update or delete to the database.
 */


public class UserService {
	
	/*
	 * Created the User Validator Method.
	 * This Method will return the UserValidator Object.
	 * Using This object to Get Access the UserValidator class Method's.
	 */
	public static UserValidator userValidator() {
		UserValidator uv = new UserValidator();
		return uv;
	}
	
	/*
	 * Created the User Dao Method. 
	 * This Method will return the UserDao Object.
	 * Using this Object to Get Access the UserDao Class Method's
	 */
	public static UserDao userDao() {
		UserDao ud = new UserDao();
		return ud;
	}
	
	/*
	 * Add User Service Method 
	 */
	public boolean addUser(User user) throws InvalidUserException, DAOException {
		
		/*
		 * Passing the User Object in the User Validator Method. This Method 
		 * Validate the User Object if the User Object is valid it should send the 
		 * User object to the Add User Dao Layer Otherwise it will throw the 
		 * Exception.
		 */
		if(userValidator().validate(user)) {
			userDao().addUser(user);
		}
		return true;
		
	}
	
	/*
	 * Update User Service Method
	 */
	public boolean updateUser(User user) throws InvalidUserException, DAOException {
		
		/*
		 * Here Validating a User Object Through the user Validator If the user 
		 * Object is valid It should send the User Object to the Update User Dao
		 * Layer. Otherwise It will throw the Exception.
		 */
		if(userValidator().validate(user)) {
			userDao().updateUser(user);
		}
		return true;
		
	}
	
	
	/*
	 * Get All User Details Method  It is not have any parameter to validate
	 * So this Method Dirtily call the Dao Layer Method.
	 */
	public boolean getAllUserDetails() throws DAOException {

		userDao().getAllUserDetails();
		return true;
	}
	
}
