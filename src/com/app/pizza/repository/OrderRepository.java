package com.app.pizza.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.app.pizza.model.OrderDetails;

public class OrderRepository {

	AtomicInteger orderIdGenerator = new AtomicInteger();
	private static OrderRepository instance;

	private OrderRepository() {
	}

	public static OrderRepository getInstance() {
		if (instance == null) {
			instance = new OrderRepository();
		}
		return instance;
	}

	// order id to order details mapping
	private final Map<Integer, OrderDetails> orders = new ConcurrentHashMap<>();

	public OrderDetails updateOrder(OrderDetails order) {
		return this.orders.put(order.getOrderId(), order);
	}

	public OrderDetails addOrder(OrderDetails order) {
		int id=orderIdGenerator.incrementAndGet();
		order.setOrderId(id);
		return this.orders.put(id, order);
	}
	public OrderDetails getOrder(Integer orderId) {
		return this.orders.get(orderId);
	}
	public List<OrderDetails> getAllOrders() {
		return (List<OrderDetails>) orders.values();
	}

}
