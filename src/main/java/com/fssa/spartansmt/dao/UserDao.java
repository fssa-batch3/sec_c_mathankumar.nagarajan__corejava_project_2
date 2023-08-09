package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.spartansmt.constants.UserConstants;
import com.fssa.spartansmt.errors.ProductValidatorErrors;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.User;
import com.fssa.spartansmt.util.ConnectionUtil;

/*
 * @author MathankumarNagarajan
 */

public class UserDao {

	public boolean addUser(User user) throws DAOException {

		/*
		 *  Get Connection form Connection Util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			/*
			 *  Declaring Query as a String and Using final Keyword
			 */
			final String query = "INSERT INTO user(first_name, last_name, email, phone_number, password) values ( ?, ?, ?, ?, ? )";

			/*
			 *  Created Prepared Statement And It'll Execute Query
			 */
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getFirstName());
				pst.setString(2, user.getLastName());
				pst.setString(3, user.getEmail());
				pst.setString(4, user.getPhoneNumber());
				pst.setString(5, user.getPassword());
				pst.executeUpdate();

				Logger.info("User Details Successfully Added To The Database");
				
			}

		} catch (SQLException ex) {
			throw new DAOException("Add User Method is Failded");
		}

		return true;

	}

	public boolean updateUser(User user) throws DAOException, InvalidUserException {

		/*
		 *  Validating Store ID if the user id is Zero or Less then Zero it will throw 
		 *  the Exception Otherwise next step codes will execute.
		 */
		if (user.getUserId() <= UserConstants.INVALID_USER_ID) {
			throw new InvalidUserException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}

		/*
		 *  Get connection from connection util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "UPDATE user SET first_name = ?, last_name = ?, phone_number = ?, password = ? WHERE user_id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getFirstName());
				pst.setString(2, user.getLastName());
				pst.setString(3, user.getPhoneNumber());
				pst.setString(4, user.getPassword());
				pst.setInt(5, user.getUserId());
				pst.executeUpdate();

				Logger.info("User Details Updated Successfully");
				
			}

		} catch (SQLException ex) {
			throw new DAOException("Update User Details Method Is Failded");
		}

		return true;

	}

	public boolean getAllUserDetails() throws DAOException {

		/*
		 *  Get Connection From Connection Util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			/*
			 *  Get All Store Details from Database. Declared Query as a String and Declared
			 *  final keyword.
			 */
			final String query = "select * from user";

			/*
			 *  Connection Util Class CreateStatement Method Assigned by Statement Interface
			 */
			try (Statement st = con.createStatement()) {

				/*
				 *  Created ResultSet And Executing SQL Query
				 */
				try (ResultSet rs = st.executeQuery(query)) {

					/*
					 *  Get All Store Details using ResultSet and Printing Store Details One by One.
					 */
					while (rs.next()) {

						System.out.println("User ID: " + rs.getInt("user_id") + ", First Name: "
								+ rs.getString("first_name") + ", Last Name: " + rs.getString("last_name")
								+ ", Phonenumber: " + rs.getString("phone_number") + ", Email: " + rs.getString("email")
								+ ", Password: " + rs.getString("password"));

					}

				}

			}

		} catch (SQLException ex) {
			throw new DAOException("Error for fetching Product Details");
		}

		return true;

	}

}
