package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.Product;
import com.fssa.spartansmt.util.ConnectionUtil;

/*
 * @author MathankumarNagarajan
 * 
 * A class which holds the Date access object
 * It has methods with sql queries the methods will do CRUD operations on the product model object
 */

public class ProductDao {

	/*
	 *  Add Product Details to the Database Table through the Add Product Method
	 */
	public boolean addProduct(Product product) throws DAOException {

		/*
		 *  Get Connection form Connection Util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			/*
			 *  Declaring Query as a String and Using final Keyword
			 */
			final String query = "INSERT INTO products(product_title, product_price, product_image, store_id, uploaded_date) values (?,?,?,?,?)";

			/*
			 *  Created Prepared Statement And It'll Execute Query
			 */
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getProductTitle());
				pst.setDouble(2, product.getProductPrice());
				pst.setString(3, product.getProductImage());
				pst.setInt(4, product.getStoreId());
				pst.setDate(5, Date.valueOf(product.getUploadedDate()));
				pst.executeUpdate();

				Logger.info("Product Added Successfully To The Database");
				
			}

		} catch (SQLException ex) {
			throw new DAOException("Add Product to the Database Method is Failded");
		}

		return true;

	}

	/*
	 *  Update Product Details to the Database Table Through the UpdateProduct Method
	 */
	public static boolean updateProduct(Product product) throws DAOException {

		/*
		 *  Get connection from connection util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			/*
			 * Declaring a Query as a String and it also a constant value.
			 */
			final String query = "UPDATE products SET product_title = ?, product_price = ?, product_image = ?, uploaded_date = ? WHERE product_id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, product.getProductTitle());
				pst.setDouble(2, product.getProductPrice());
				pst.setString(3, product.getProductImage());
				pst.setInt(5, product.getProductId());
				pst.setDate(4, Date.valueOf(LocalDate.now()));
				pst.executeUpdate();

				// Print Statement
				Logger.info("Product Updated Successfully");
				
			}

		} catch (SQLException ex) {
			throw new DAOException("Update Product Details to Datadase Method Is Failded");
		}

		return true; 

	}

	/*
	 * deleteProduct Method will delete the product object
	 * in the database product table.
	 */
	public static boolean deleteProduct(int productId) throws DAOException {

		/*
		 *  Get Connection From Connection Util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			/*
			 *  Declaring Delete Store Details Query as a String and declared as a final key
			 */
			final String query = "DELETE FROM products WHERE product_id = ?";

			/*
			 *  Created Prepared Statement and Executing Query
			 */
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, productId);
				pst.executeUpdate();

			}

		} catch (SQLException ex) {
			throw new DAOException("Error For Deleting Product Details");
		}

		/*
		 *  Print Statement
		 */
		Logger.info("Deleted Successfully");
		
		return true;

	}

	public List<Product> getAllProductDetails() throws DAOException {
		
		// Created a List Object
		List<Product> productList = new ArrayList<>();

		/*
		 *  Get Connection From Connection Util
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			/*
			 *  Get All Store Details from Database. Declared Query as a String and Declared
			 *  final keyword.
			 */
			final String query = "select * from products";

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
						
						Product product = createProductFromResultSet(rs);
						productList.add(product);

					}

				}

			}

		} catch (SQLException ex) {
			throw new DAOException("Error for fetching Product Details");
		}

		// Returning a product list (ArrayList).
		return productList;

	}
	
	/*
	 * This Method is Get an Object through the getAllProductDetails Method
	 * And Set Object Value's to Product Object And It will Return the 
	 * Product Object.
	 */
	public static Product createProductFromResultSet(ResultSet rs) throws SQLException {
		
		/*
		 * Created a empty Project Object
		 */
		Product product = new Product();
		
		/*
		 * Assigning a Value to Product Using Setter Method
		 */
		product.setProductId(rs.getInt("product_id"));
		product.setStoreId(rs.getInt("store_id"));
		product.setProductTitle(rs.getString("product_title"));
		product.setProductPrice(rs.getDouble("product_price"));
		product.setProductImage(rs.getString("product_image"));
		
		// Returning the product object.
		return product;
		
	}
	
	/*
	 * This Method is Get the one specific store Products.
	 */
	public List<Product> getAllProductByStoreId(int storeId) throws DAOException{
		
		// Created a List Object
				List<Product> productList = new ArrayList<>();

				/*
				 *  Get Connection From Connection Util
				 */
				try (Connection con = ConnectionUtil.getConnection()) {

					/*
					 *  Get Specific Store Product Details from Database. Declared Query as a String and Declared
					 *  final keyword.
					 */
					final String query = "select * from products where store_id = '" + storeId + "'";

					/*
					 *  Connection Util Class CreateStatement Method Assigned by Statement Interface
					 */
					try (Statement st = con.createStatement()) {

						/*
						 *  Created ResultSet And Executing SQL Query
						 */
						try (ResultSet rs = st.executeQuery(query)) {

							/*
							 *  Get Specific Store Product Details using ResultSet and It will Print The Store Product Details One by One.
							 */
							while (rs.next()) {
								
								Product product = createProductFromResultSet(rs);
								productList.add(product);

							}

						}

					}

				} catch (SQLException ex) {
					throw new DAOException("Error for Get all product by store Method is Failded");
				}

				// Returning a product list (ArrayList).
				return productList;
		
		
		
	}
	
	
	
}
