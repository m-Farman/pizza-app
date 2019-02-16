package com.app.pizza.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OrderDetails {

	private Integer orderId;
	// orderedPizza contain the pizza which are order and there respective counts
	private Map<Pizza, Integer> orderedPizza = new HashMap<>();

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Set<Pizza> getOrderedPizza() {
		return orderedPizza.keySet();
	}

	public Integer getPizzaCount(Pizza pizza) {
		return orderedPizza.get(pizza);
	}

	public Map<Pizza, Integer> getOrder() {
		return orderedPizza;
	}

	public Integer addPizzaOrdered(Pizza pizza, Integer count) {
		int orderCount = count;
		if (orderedPizza.containsKey(pizza)) {
			orderCount = orderedPizza.get(pizza) + count;
		}

		return orderedPizza.put(pizza, orderCount);
	}

}
