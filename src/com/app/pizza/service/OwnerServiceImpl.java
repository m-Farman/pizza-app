package com.app.pizza.service;

import java.io.IOException;

import com.app.pizza.exception.NoPizzaFoundException;
import com.app.pizza.model.Pizza;
import com.app.pizza.util.InputOutputUtil;

public class OwnerServiceImpl implements OwnerService{

	private MenuService menuService;

	public OwnerServiceImpl(MenuService menuService) {
		this.menuService = menuService;
	}

	public boolean handleOwnerRequest() throws Exception {

		do {
			showOwnerOperation();
			Integer input = InputOutputUtil.readInteger();
			switch (input) {
			case 1:
				handleViewModifyPizza();
				break;
			case 2:
				InputOutputUtil.print("Enter pizza Id");
				input = InputOutputUtil.readInteger();
				try {
					menuService.addPizzaToMenu(input);
				} catch (NoPizzaFoundException e) {
					InputOutputUtil.wrongInputMsg("Invalid Pizza Id");
				}
				break;
			case 3:
				InputOutputUtil.print("Enter pizza Id");
				input = InputOutputUtil.readInteger();
				Pizza piz = menuService.deletePizza(input);
				if (piz != null) {
					InputOutputUtil.print("Delete successful");
				} else {
					InputOutputUtil.print("Delete failed");
				}
				break;
			case 4:
				return true;
			default:
				InputOutputUtil.wrongInputMsg();
				break;
			}
		} while (true);
	}

	private void handleViewModifyPizza() throws NumberFormatException, IOException {

		menuService.displayAllPizza();
		InputOutputUtil.print("Enter Input 1) for modifying the price of pizza \n 2) for back");
		Integer input = InputOutputUtil.readInteger();
		switch (input) {
		case 1:
			InputOutputUtil.print("Enter pizza Id");
			input = InputOutputUtil.readInteger();
			InputOutputUtil.print("Enter new price");
			Double price = InputOutputUtil.readDouble();
			try {
				menuService.updatePizzaPrice(input, price);
			} catch (NoPizzaFoundException e) {
				InputOutputUtil.wrongInputMsg("Invalid Pizza Id");
			}
			break;
		case 2:
			return;
		default:
			InputOutputUtil.wrongInputMsg();
			break;
		}
	}

	private void showOwnerOperation() {
		InputOutputUtil.print("Please enter :" 
				+ "\n 1) to view and modify the prices of the pizzas "
				+ "\n 2) for add pizza to menu " 
				+ "\n 3) for deleting pizza from menu" 
				+ "\n 4) for back");
	}

}

//InputOutputUtil.print("Enter pizza name and price");
//String str = InputOutputUtil.readString();
//Pizza pizza = null;
//try {
//	pizza = ParserUtil.parsePizza(str);
//} catch (Exception e) {
//	InputOutputUtil.wrongInputMsg();
//	break;
//}
//menuService.savePizza(pizza);
