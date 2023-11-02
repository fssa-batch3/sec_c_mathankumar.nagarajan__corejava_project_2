package com.fssa.spartansmt.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.spartansmt.exception.DAOException;
import com.fssa.spartansmt.exception.InvalidOrderDetailsException;
import com.fssa.spartansmt.exception.InvalidUserException;
import com.fssa.spartansmt.model.Order;
import com.fssa.spartansmt.model.OrderedProduct;

public class TestOrderService {
	
	@Test
	void testPlaceOrder() throws DAOException, InvalidOrderDetailsException, InvalidUserException {
		
		OrderService os = new OrderService();
		
		Order order = new Order();
		order.setUserId(1);
		order.setTotalPrice(2999.53);
		order.setPaymentOption("Cash On Delivery");
		order.setOrderDate(LocalDate.now());
		
		List<OrderedProduct> orderedList = new ArrayList<>();
		OrderedProduct op1 = new OrderedProduct(1, 2);
		OrderedProduct op2 = new OrderedProduct(2, 2);
		OrderedProduct op3 = new OrderedProduct(3, 2);
		orderedList.add(op1);
		orderedList.add(op2);
		orderedList.add(op3);
		
		order.setOrderedProducts(orderedList);
		order.setAddress("1212 Chennai");
		order.setCountry("India");
		order.setState("Chennai");
		order.setZipCode(623807);
		
		Assertions.assertTrue(os.placeOrder(order));
		
	}
	
	@Test
	void testGetAllOrderUsingUserId() throws InvalidOrderDetailsException, DAOException {
		
		OrderService os = new OrderService();
		List<Order> orderList = os.getAllOrdersUsingUserId(4);
		
		
	}
	
	
	@Test 
	void testGetOrderUsingOrderId() throws InvalidOrderDetailsException, DAOException {
		
		OrderService os = new OrderService();
		Order order = os.getOrderUsingOrderId(1);
		
	}

}
