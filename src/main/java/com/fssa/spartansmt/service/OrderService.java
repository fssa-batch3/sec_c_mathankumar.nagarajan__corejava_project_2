package com.fssa.spartansmt.service;

import java.util.Collections;
import java.util.List;

import com.fssa.spartansmt.dao.OrderDao;
import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.model.Order;
import com.fssa.spartansmt.validator.OrderValidator;

/*
 * @author MathankumarNagarajan
 * 
 * A class which holds the services for order model object
 * It acts has mediator between validator and DAO class
 */

public class OrderService {

	public boolean placeOrder(Order order) throws DAOException, InvalidOrderDetailsException {
		OrderValidator orderValidator = new OrderValidator();
		if (orderValidator.validateOrder(order)) {
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
	
}
