package com.fssa.spartansmt.service;

import java.util.Collections;
import java.util.List;

import com.fssa.spartansmt.dao.OrderDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.Order;
import com.fssa.spartansmt.model.User;
import com.fssa.spartansmt.validator.OrderValidator;
import com.fssa.spartansmt.validator.UserValidator;

/* 
 * @author MathankumarNagarajan
 * 
 * A class which holds the services for order model object
 * It acts has mediator between validator and DAO class
 */

public class OrderService {

	public boolean placeOrder(Order order) throws DAOException, InvalidOrderDetailsException, InvalidUserException {
		OrderValidator orderValidator = new OrderValidator();
		UserValidator userVali = new UserValidator();
		User user = new User(order.getAddress(), order.getCountry(), order.getState(), order.getZipCode());
		if (orderValidator.validateOrder(order) && userVali.validateAddressDetails(user)) {
			OrderDao orderDao = new OrderDao();
			orderDao.placeOrder(order);
		}

		return true;

	}

	public List<Order> getAllOrdersUsingUserId(int userId) throws InvalidOrderDetailsException, DAOException {

		try {
			if (OrderValidator.validateUserId(userId)) {
				OrderDao orderDao = new OrderDao();
				return orderDao.getAllOrdersUsingUserId(userId);
			}
		}catch(InvalidOrderDetailsException ex) {
			throw new InvalidOrderDetailsException(ex.getMessage());
		}
		return Collections.emptyList();

	}
	
	
	public Order getOrderUsingOrderId(int orderId) throws InvalidOrderDetailsException, DAOException {

		Order order = new Order();
		try {
			if (OrderValidator.validateOrderId(orderId)) {
				OrderDao orderDao = new OrderDao();
				order = orderDao.getOrderUsingOrderId(orderId);
			}
		}catch(InvalidOrderDetailsException ex) {
			throw new InvalidOrderDetailsException(ex.getMessage());
		}
		return order;

	}
	
}
