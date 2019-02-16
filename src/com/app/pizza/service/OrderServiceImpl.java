package com.app.pizza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.app.pizza.exception.OrderNotFoundException;
import com.app.pizza.model.Bill;
import com.app.pizza.model.BillItem;
import com.app.pizza.model.Order;
import com.app.pizza.model.OrderDetails;
import com.app.pizza.model.Pizza;
import com.app.pizza.repository.MenuRepository;
import com.app.pizza.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {

	public OrderDetails updateOrder(Integer orderId, List<Order> orders) {
		OrderRepository orderRepository = OrderRepository.getInstance();
		MenuRepository menuRepository = MenuRepository.getInstance();
		OrderDetails orderDetails = orderRepository.getOrder(orderId);

		for (Order order : orders) {
			Pizza pizza = menuRepository.getPizza(order.getPizzaId());
			orderDetails.addPizzaOrdered(pizza, order.getCount());
		}

		return orderRepository.updateOrder(orderDetails);
	}

	public OrderDetails addNewOrder(List<Order> orders) {
		OrderRepository orderRepository = OrderRepository.getInstance();
		OrderDetails orderDetails = new OrderDetails();
		orderRepository.addOrder(orderDetails);
		return updateOrder(orderDetails.getOrderId(), orders);
	}

	public Bill computeBill(Integer orderId) throws OrderNotFoundException {
		OrderRepository orderRepository = OrderRepository.getInstance();
		OrderDetails orderDetails = orderRepository.getOrder(orderId);

		if (Objects.isNull(orderDetails)) {
			throw new OrderNotFoundException();
		}
		
		List<BillItem> billItems = new ArrayList<>();
		double totalAmount = 0;
		for (Pizza pizza : orderDetails.getOrderedPizza()) {
			int count = orderDetails.getPizzaCount(pizza);
			double amount = pizza.getPrice() * count;
			totalAmount += amount;
			BillItem billItem = new BillItem(pizza.getName(), count, amount);
			billItems.add(billItem);
		}
		Bill bill = new Bill();
		bill.setBillItems(billItems);
		bill.setTotalBillAmount(totalAmount);
		return bill;
	}
}
