package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.spartansmt.errors.StoreValidatorErrors;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidStoreDetailsException;
import com.fssa.spartansmt.model.Store;
import com.fssa.spartansmt.util.ConnectionUtil;

public class StoreDao {

	/*
	 *  Add Store Details to Database Using add Store Method
	 */
	public static boolean addStore(Store store) throws DAOException { 

		/*
		 *  Get Connection from Connection Util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {
			
			/*
			 *  Declaring MySQL Query as final String
			 */
			final String query = "INSERT INTO stores(store_name, category, store_logo) values (?,?,?)";

			/*
			 *  Created Prepared Statement And Executing SQL Query
			 */
			try (PreparedStatement pst = con.prepareStatement(query)) {
				
				pst.setString(1, store.getName());
				pst.setString(2, store.getCategory());
				pst.setString(3, store.getStoreLogoLink());
				pst.executeUpdate();
			}

		} catch (SQLException e) {
			throw new DAOException("Error for Adding Store Details");
		}

		/*
		 *  Print Statement
		 */
		System.out.println("Added Successfully");

		return true;
 
	}

	/*
	 *  Update Store Details Method 
	 */
	public static boolean updateStore(Store store) throws DAOException, InvalidStoreDetailsException {
		
		/*
		 *  Validating Store ID 
		 */
		if(store.getId() <= 0) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_ID);
		}
		
		/*
		 *  Get Connection From Connection Util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {
			
			/*
			 *  Declaring MySQL Query for Update Store Details as a String And Declared as a final key
			 */
			final String query = "UPDATE stores SET store_name = ?, category = ?, store_logo = ? WHERE store_id = ?";

			/*
			 *  Created Prepared Statement and Executed Query
			 */
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, store.getName());
				pst.setString(2, store.getCategory());
				pst.setString(3, store.getStoreLogoLink());
				pst.setInt(4, store.getId());
				pst.executeUpdate();
			}
 
		} catch (SQLException e) {
			throw new DAOException("Error for Updating Store Details");
		}

		/*
		 *  Print Statement
		 */
		System.out.println("Updated Successfully");

		return true;

	}
	
	/*
	 *  Delete Store Details Method 
	 */
	public static boolean deleteStore(int storeId) throws DAOException, InvalidStoreDetailsException {
		
		/*
		 *  Validate Store ID it must have more then "ZERO".
		 */
		if(storeId <= 0) {
			throw new InvalidStoreDetailsException(StoreValidatorErrors.INVALID_STORE_ID);
		}
		
		/*
		 *  Get Connection From Connection Util
		 */
		try(Connection con = ConnectionUtil.getConnection()){
			
			/* 
			 * Declaring Delete Store Details Query as a String and declared as a final key
			 */
			final String query = "DELETE FROM stores WHERE store_id = ?";
			
			/*
			 *  Created Prepared Statement and Executing Query
			 */
			try(PreparedStatement pst = con.prepareStatement(query)){
				
				pst.setInt(1, storeId);
				pst.executeUpdate();
				
			}
			
		}catch(SQLException ex) {
			throw new DAOException("Error For Deleting Store Details");
		}
		
		/*
		 *  Print Statement
		 */
		System.out.println("Deleted Successfully");
		
		return true;
		
	}
	
	public static boolean getAllStoreDetails() throws DAOException {
		
		/*
		 *  Get Connection From Connection Util
		 */
		try(Connection con = ConnectionUtil.getConnection()){
			
			/*
			 *  Get All Store Details from Database. Declared Query as a String and Declared final keyword.
			 */
			final String query = "select * from stores";
			
			/*
			 *  Connection Util Class CreateStatement Method Assigned by Statement Interface
			 */
			try(Statement st = con.createStatement()){
				
				/*
				 *  Created ResultSet And Executing SQL Query
				 */
				try(ResultSet rs = st.executeQuery(query)){
					
					/*
					 *  Get All Store Details using ResultSet and Printing Store Details One by One.
					 */
					while(rs.next()) {
						
						System.out.println("Store ID: " + rs.getInt("store_id") + ", Store Name: " + rs.getString("store_name") + ", Store Category: " + rs.getString("category") + ", Store Logo Link: " + rs.getString("store_logo"));
						
					}
					
				}
				
			}
			
		}catch(SQLException ex) {
			throw new DAOException("Error for fetching Store Details");
		}
		
		return true;
		
	}

}
