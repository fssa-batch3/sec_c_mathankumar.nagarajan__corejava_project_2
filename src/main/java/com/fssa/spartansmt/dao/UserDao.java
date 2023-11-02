package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.spartansmt.constants.UserConstants;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidUserException;
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
			final String query = "INSERT INTO user(first_name, last_name, email, phone_number, password, role) values ( ?, ?, ?, ?, ?, ?)";

			/*
			 *  Created Prepared Statement And It'll Execute Query
			 */
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getFirstName());
				pst.setString(2, user.getLastName());
				pst.setString(3, user.getEmail());
				pst.setLong(4, user.getPhoneNumber());
				pst.setString(5, user.getPassword());
				pst.setString(6, UserConstants.USER);
				pst.executeUpdate(); 

				
			}

		} catch (SQLException ex) {
			throw new DAOException("Add User Method is Failded");
		}

		return true;

	}
	
	public boolean checkEmployeeExists(String email) throws DAOException, SQLException {
		String query = "SELECT email FROM user WHERE email = ?";
		boolean isValid;
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, email);
				try (ResultSet rs = pst.executeQuery()) {
					isValid = rs.next();
				}
			}
		}
		if(isValid) {
			throw new DAOException("The User Already Exists");
		}
		return true;
		
	}

	public boolean updateUser(User user) throws DAOException, InvalidUserException {

		/*
		 *  Get connection from connection util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "UPDATE user SET first_name = ?, last_name = ?, phone_number = ?, address = ?, country = ?, state = ?, zipcode = ? WHERE user_id = ?;";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getFirstName());
				pst.setString(2, user.getLastName());
				pst.setLong(3, user.getPhoneNumber());
				
				pst.setString(4, user.getAddress());
				pst.setString(5, user.getCountry());
				pst.setString(6, user.getState());
				pst.setInt(7, user.getZipCode());
				
				pst.setInt(8, user.getUserId());
				pst.executeUpdate();

				
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
			final String query = "select user_id, first_name, last_name, email, password, phone_number, address, country, state, zipcode, role from user";

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
					if (rs.next()) {

						return true;
						
					}

				}

			}

		} catch (SQLException ex) {
			throw new DAOException("Error for fetching All User Details");
		}

		return true;

	}
	
	
	public User getUserByEmail(String email) throws DAOException {
		
		User user = new User();
		
		try(Connection con = ConnectionUtil.getConnection()){
			
			final String query = "select user_id, first_name, last_name, email, password, phone_number, address, country, state, zipcode, role from user where email = ?";
			try(PreparedStatement ps = con.prepareStatement(query)){
				
				ps.setString(1, email);
				
				try(ResultSet rs = ps.executeQuery()){
					
					if(rs.next()) {
						
						user.setFirstName(rs.getString("first_name"));
						user.setLastName(rs.getString("last_name"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
						user.setPhoneNumber(rs.getLong("phone_number"));
						user.setUserId(rs.getInt("user_id"));
						
						user.setAddress(rs.getString("address"));
						user.setCountry(rs.getString("country"));
						user.setState(rs.getString("state"));
						user.setZipCode(rs.getInt("zipcode"));
						user.setRole(rs.getString("role"));
					}
					
				}
				
			}
			
		}catch(SQLException e) {
			throw new DAOException("Invalid Email Address");
		}
		return user;
		
	}
	
	public int getUserIdUsingEmail(String email) throws DAOException {
		
		int userId = 0;
		
		try(Connection con = ConnectionUtil.getConnection()){
			
			final String query = "select user_id from user where email = ?";
			try(PreparedStatement pst = con.prepareStatement(query)){
				
				pst.setString(1, email);
				
				try(ResultSet rs = pst.executeQuery()){
					
					if(rs.next()) {
						
						userId = rs.getInt("user_id");
						return userId;
					}
					
				}
				
			}
			
		}catch(SQLException e) {
			throw new DAOException("Get User ID By User Email Method Is Failded");
		}
		
		return userId;
		
	}

}
