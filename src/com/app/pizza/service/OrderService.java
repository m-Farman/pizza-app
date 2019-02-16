package com.app.pizza.service;

import java.util.List;

import com.app.pizza.exception.OrderNotFoundException;
import com.app.pizza.model.Bill;
import com.app.pizza.model.Order;
import com.app.pizza.model.OrderDetails;

public interface OrderService {

	public OrderDetails updateOrder(Integer orderId, List<Order> orders);

	public OrderDetails addNewOrder(List<Order> orders);
	
	public Bill computeBill(Integer orderId) throws OrderNotFoundException;
}
