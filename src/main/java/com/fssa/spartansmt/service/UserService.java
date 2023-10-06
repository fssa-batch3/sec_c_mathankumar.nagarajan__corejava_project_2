package com.fssa.spartansmt.service;

import java.sql.SQLException;

import com.fssa.spartansmt.constants.UserConstants;
import com.fssa.spartansmt.dao.UserDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.exception.ServiceException;
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
	 * Add User Service Method
	 */
	public boolean addUser(User user) throws InvalidUserException, DAOException, ServiceException, SQLException {

		/*
		 * Passing the User Object in the User Validator Method. This Method Validate
		 * the User Object if the User Object is valid it should send the User object to
		 * the Add User Dao Layer Otherwise it will throw the Exception.
		 */

		try {
			if (new UserValidator().validate(user)) {
				if (new UserDao().checkEmployeeExists(user.getEmail())) {
					new UserDao().addUser(user);
				}
			}
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return true;

	}

	/*
	 * Update User Service Method
	 */
	public boolean updateUser(User user) throws InvalidUserException, DAOException {

		/*
		 * Here Validating a User Object Through the user Validator If the user Object
		 * is valid It should send the User Object to the Update User Dao Layer.
		 * Otherwise It will throw the Exception.
		 */
		if (new UserValidator().validateUpdateUserObj(user) && new UserValidator().validateId(user.getUserId())
				&& new UserValidator().validateAddressDetails(user)) {
			new UserDao().updateUser(user);
		}
		return true;

	}

	/*
	 * Get All User Details Method It is not have any parameter to validate So this
	 * Method Dirtily call the Dao Layer Method.
	 */
	public boolean getAllUserDetails() throws DAOException {

		new UserDao().getAllUserDetails();
		return true;
	}

	public User getUserByEmail(String email) throws DAOException, InvalidUserException, ServiceException {

		User user = null;
		try {
			if (new UserValidator().validateEmail(email)) {
				user = new UserDao().getUserByEmail(email);
			}
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return user;

	}

	public boolean login(String email, String password) throws InvalidUserException, ServiceException {

		try {
			new UserValidator().validateEmail(email);
			new UserValidator().validatePassword(password);
		} catch (InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
		return true;

	}

	public int getUserIdUsingEmail(String email) throws ServiceException {

		int userId = UserConstants.INVALID_USER_ID;

		try {

			if (new UserValidator().validateEmail(email)) {
				userId = new UserDao().getUserIdUsingEmail(email);
			}

		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return userId;

	}

	public String convertHashPassword(String password) throws InvalidUserException, ServiceException {

		String hashPassword = null;
		try {
			if (new UserValidator().validatePassword(password)) {
				hashPassword = new UserValidator().hashPassword(password);
			}
		} catch (InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

		return hashPassword;
	}

}
