package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.model.Order;
import com.fssa.spartansmt.util.ConnectionUtil;


public class OrderDao {
	
	public boolean placeOrder(Order order) throws DAOException {
		
		try(Connection con = ConnectionUtil.getConnection()){
			
			final String query = "INSERT INTO ORDERS (user_id, total_price, payment_status) VALUES (?, ?, ?)";
			try(PreparedStatement pst = con.prepareStatement(query)){
				
				pst.setInt(1, order.getUserId());
				pst.setInt(2, order.getTotalPrice());
				pst.setString(3, order.getStatus());
				pst.executeUpdate();
				System.out.println("Successfully Placed Order");
				
			}
			
			final String query2 = "INSERT INTO ORDERED_PRODUCT (order_id, product_id, quentity) VALUES (?, ?, ?);";
			try(PreparedStatement pst = con.prepareStatement(query2)){
				
				pst.setInt(1, getOrderId(order.getUserId()));
				pst.setInt(2, order.getProductId());
				pst.setInt(3, order.getQuentity());
				pst.executeUpdate();
				System.out.println("Successfully Placed Product");
				
			}
			
		}catch(SQLException ex) {
			throw new DAOException("Place Order Method Is Failded");
		}
		
		return true;
	}
	
	public static int getOrderId(int userId) throws DAOException {
		
		try(Connection con = ConnectionUtil.getConnection()){
			
			final String query = "SELECT order_id FROM ORDERS WHERE user_id = '" + userId + "'";
			try(Statement st = con.createStatement()){
				
				try(ResultSet rs = st.executeQuery(query)){
					
					int a = 0;
					while(rs.next()) {
						a = rs.getInt("order_id");
					}
					
					return a;
					
				}
				
			}
			
		}catch(SQLException ex) {
			throw new DAOException("Get Order Id Method Is Failded");
		}
		
	}
	
	public static void main(String[] args) throws DAOException {
		
		Order or = new Order(1,2,1999);
		OrderDao orderDao = new OrderDao();
		orderDao.placeOrder(or);
		
	}

}
