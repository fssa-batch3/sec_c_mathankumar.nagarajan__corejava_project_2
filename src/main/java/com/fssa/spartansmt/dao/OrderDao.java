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

import com.fssa.spartansmt.constants.OrderConstants;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.logger.Logger;
import com.fssa.spartansmt.model.Order;
import com.fssa.spartansmt.model.OrderedProduct;
import com.fssa.spartansmt.util.ConnectionUtil;

/*
 * @author MathankumarNagarajan
 * 
 * A class which holds the Data access object
 * It has method with sql queries the methods will do create and get operations on the order model object
 */

public class OrderDao {

	// Declared a Constant Variable 
	private String ORDER_ID = "order_id";

	/*
	 * placeOrder Method will place the order to the Database order table.
	 */
	public boolean placeOrder(Order order) throws DAOException {

		/*
		 * Declared a integer data type variable it hold the invalid order id (0).
		 */
		int orderId = OrderConstants.INVALID_ORDER_ID;

		/*
		 * Here is used try with resources.
		 */
		try (Connection con = ConnectionUtil.getConnection()) {

			/*
			 * Declared a sql query as a final constant variable String
			 */
			final String query = "INSERT INTO orders (user_id, total_price, payment_option, ordered_date, shipping_address, country, state, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			/*
			 * Here is prepared statement will execute the query And it will add to the
			 * order table in the database.
			 */
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, order.getUserId());
				pst.setDouble(2, order.getTotalPrice());
				pst.setString(3, order.getPaymentOption());
				pst.setDate(4, Date.valueOf(LocalDate.now()));

				pst.setString(5, order.getAddress());
				pst.setString(6, order.getCountry());
				pst.setString(7, order.getState());
				pst.setInt(8, order.getZipCode());

				pst.executeUpdate();

				/*
				 * Here is getting the order id using user id. getOrderId Method return the
				 * order id.
				 * 
				 * (Invoked getOrderId Method).
				 */
				orderId = getOrderId(order.getUserId());

				// Print Statement
				Logger.info("Successfully Placed Order");

			}

			/*
			 * Here is
			 */
			for (OrderedProduct e : order.getOrderedProducts()) {

				placeOrderedProduct(e, orderId);

			}

		} catch (SQLException ex) {
			throw new DAOException("Place Order Method Is Failded");
		}

		return true;

	}

	public boolean placeOrderedProduct(OrderedProduct orderedProduct, int orderId) throws DAOException {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query2 = "INSERT INTO ordered_products (order_id, product_id, quantity) VALUES (?, ?, ?)";
			try (PreparedStatement pst = con.prepareStatement(query2)) {

				pst.setInt(1, orderId);
				pst.setInt(2, orderedProduct.getProductId());
				pst.setInt(3, orderedProduct.getQuantity());
				pst.executeUpdate();
				Logger.info("Successfully Placed Product");

			}

		} catch (SQLException ex) {
			throw new DAOException("Place OrderedProduct Method Is Failded");
		}

		return true;

	}

	public int getOrderId(int userId) throws DAOException {

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "SELECT order_id FROM orders WHERE user_id = ? ORDER BY order_id DESC LIMIT 1";
			try (PreparedStatement st = con.prepareStatement(query)) {
				st.setInt(1, userId);
				try (ResultSet rs = st.executeQuery()) {
					if (rs.next()) {
						return rs.getInt("order_id");
					}

				}

			}
			return 0;

		} catch (SQLException ex) {
			throw new DAOException("Get Order Id Method Is Failded");
		}
	}

	public List<Order> getAllOrdersUsingUserId(int userId) throws DAOException {

		List<Order> ordersList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "select * from orders where user_id = '" + userId + "'";
			try (Statement st = con.createStatement()) {

				try (ResultSet rs = st.executeQuery(query)) {

					while (rs.next()) {

						Order order = createOrderFromResultSet(rs);

						ordersList.add(order);

					}

				}

			}

		} catch (SQLException ex) {
			throw new DAOException("Get All Orders Using User Id Method Is Failded");
		}

		return ordersList;

	}

	public Order createOrderFromResultSet(ResultSet rs) throws DAOException {

		try {

			Order order = new Order();
			order.setOrderId(rs.getInt(ORDER_ID));
			order.setUserId(rs.getInt("user_id"));
			order.setPaymentOption(rs.getString("payment_option"));
			order.setTotalPrice(rs.getDouble("total_price"));
			order.setOrderDate(rs.getDate("ordered_date").toLocalDate());
			order.setOrderedProducts(getOrderedProduct(rs.getInt(ORDER_ID)));
			order.setAddress(rs.getString("shipping_address"));
			order.setCountry(rs.getString("country"));
			order.setState(rs.getString("state"));
			order.setZipCode(rs.getInt("zip_code"));

			return order;

		} catch (SQLException ex) {
			throw new DAOException("Create Order From ResultSet Method Is Failded");
		}

	}

	public List<OrderedProduct> getOrderedProduct(int orderId) throws DAOException {

		List<OrderedProduct> orderedProductList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "select * from ordered_products where order_id = '" + orderId + "'";
			try (Statement st = con.createStatement()) {

				try (ResultSet rs = st.executeQuery(query)) {

					while (rs.next()) {

						OrderedProduct orderedProduct = new OrderedProduct();
						orderedProduct.setOrderId(rs.getInt(ORDER_ID));
						orderedProduct.setProductId(rs.getInt("product_id"));
						orderedProduct.setQuantity(rs.getInt("quantity"));
						orderedProductList.add(orderedProduct);

					}

				}

			}

		} catch (SQLException ex) {
			throw new DAOException("Get Ordered Product Method Is Failded");
		}

		return orderedProductList;

	}
	
	
	public Order getOrderUsingOrderId(int orderId) throws DAOException {

		Order order = new Order();

		try (Connection con = ConnectionUtil.getConnection()) {

			final String query = "select * from orders where order_id = ?";
			try (PreparedStatement st = con.prepareStatement(query)) {
				st.setInt(1, orderId);
				try (ResultSet rs = st.executeQuery()) {

					if(rs.next()) {

						order = createOrderFromResultSet(rs);

					}

				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DAOException("Get All Orders Using Order Id Method Is Failded");
		}

		return order;

	}

}
