package com.app.pizza.util;

import com.app.pizza.model.Order;
import com.app.pizza.model.Pizza;

public class ParserUtil {

	public static Pizza parsePizza(String input) throws Exception {
		String[] tmp = input.split("\\s+");

		Pizza pizza = new Pizza();
		pizza.setName(tmp[0]);
		pizza.setPrice(Double.parseDouble(tmp[1]));

		return pizza;
	}

	public static Order parseOrder(String input) throws Exception {
		String[] tmp = input.split("\\s+");

		Order order = new Order();
		order.setPizzaId(Integer.parseInt(tmp[0]));
		order.setCount(Integer.parseInt(tmp[0]));
		return order;
	}
}
