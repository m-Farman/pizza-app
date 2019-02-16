package com.app.pizza;

import com.app.pizza.model.Pizza;
import com.app.pizza.service.MenuService;
import com.app.pizza.service.MenuServiceImpl;
import com.app.pizza.service.OrderService;
import com.app.pizza.service.OrderServiceImpl;
import com.app.pizza.service.OwnerService;
import com.app.pizza.service.OwnerServiceImpl;
import com.app.pizza.service.UserService;
import com.app.pizza.service.UserServiceImpl;
import com.app.pizza.util.InputOutputUtil;

public class PizzaAppMain {

	private static OwnerService ownerService;
	private static UserService userService;

	public static void main(String[] args) throws Exception {

		initialize();

		do {
			System.out.println("Please enter your role:\n 1) for  shop owner \n 2) for customer \n 3) for exit");
			int role = InputOutputUtil.readInteger();
			switch (role) {
			case 1:
				ownerService.handleOwnerRequest();
				break;
			case 2:
				userService.handleUserRequest();
				break;
			case 3:
				System.out.println("I am exiting. Bye !!");
				System.exit(0);
			default:
				System.out.println("Wrong Input");
			}
		} while (true);

	}

	private static void initialize() {
		MenuService menuService = new MenuServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		ownerService = new OwnerServiceImpl(menuService);
		userService = new UserServiceImpl(orderService, menuService);
		menuService.savePizza(new Pizza("Pizza 1", 20));
		menuService.savePizza(new Pizza("Pizza 2", 20.5));
		menuService.savePizza(new Pizza("Pizza 3", 30));
		menuService.savePizza(new Pizza("Pizza 4", 30.5));
		menuService.savePizza(new Pizza("Pizza 5", 40));

	}
}
