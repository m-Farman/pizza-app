package com.app.pizza.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.app.pizza.exception.OrderNotFoundException;
import com.app.pizza.model.Bill;
import com.app.pizza.model.Order;
import com.app.pizza.model.OrderDetails;
import com.app.pizza.util.InputOutputUtil;
import com.app.pizza.util.ParserUtil;

public class UserServiceImpl implements UserService {

	private OrderService orderService;
	private MenuService menuService;

	public UserServiceImpl(OrderService orderService, MenuService menuService) {
		this.orderService = orderService;
		this.menuService = menuService;
	}

	public boolean handleUserRequest() throws Exception {

		do {
			showUserOperation();
			Integer input = InputOutputUtil.readInteger();
			switch (input) {
			case 1:
				menuService.displayMenu();
				break;
			case 2:
				handleUserOrder();
				break;
			case 3:
				generateBill();
				break;
			case 4:
				return true;
			default:
				InputOutputUtil.wrongInputMsg();
				break;
			}
		} while (true);
	}

	private void generateBill() throws NumberFormatException, IOException {

		InputOutputUtil.print("Please enter Order Id");
		Integer orderId = InputOutputUtil.readInteger();
		Bill bill=null;
		try {
			bill=orderService.computeBill(orderId);
		} catch (OrderNotFoundException e) {
			InputOutputUtil.print("Wrong order Id provided");
		}
		if (Objects.nonNull(bill)) {
			bill.getBillItems().forEach(System.out::println);
			InputOutputUtil.print("Total bill amount is "+bill.getTotalBillAmount());	
		}
	}

	private void handleUserOrder() throws Exception {

		InputOutputUtil.print("Enter : \n 1) Add into existing order" + "\n 2) Create new order");
		Integer input = InputOutputUtil.readInteger();
		switch (input) {
		case 1:
			InputOutputUtil.print("Enter Order Id");
			input = InputOutputUtil.readInteger();
			List<Order> orderDetails = takeOrder();
			orderService.updateOrder(input, orderDetails);
			break;
		case 2:
			List<Order> orders = takeOrder();
			OrderDetails details = orderService.addNewOrder(orders);
			InputOutputUtil.print("Please keep this order Id for future reference " + details.getOrderId());
			break;
		default:
			InputOutputUtil.wrongInputMsg();
			break;
		}

	}

	private List<Order> takeOrder() throws Exception {
		List<Order> orderList = new ArrayList<>();
		do {
			InputOutputUtil.print("Enter : \n 1) for pizza Id and count \n 2) done ordering");
			Integer input = InputOutputUtil.readInteger();
			switch (input) {
			case 1:
				InputOutputUtil.print("Enter pizza Id and count");
				String tmp = InputOutputUtil.readString();
				Order order = ParserUtil.parseOrder(tmp);
				orderList.add(order);
				break;
			case 2:
				return orderList;
			default:
				InputOutputUtil.wrongInputMsg();
				break;
			}
		} while (true);
	}

	private void showUserOperation() {
		InputOutputUtil.print("Please enter :" + "\n 1) Menu " + "\n 2) Order "
				+ "\n 3) Bill generated for the order placed." + "\n 4) for back");
	}
}
