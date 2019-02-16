package com.app.pizza.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.app.pizza.exception.NoPizzaFoundException;
import com.app.pizza.model.Pizza;
import com.app.pizza.repository.MenuRepository;

public class MenuServiceImpl implements MenuService {

	@Override
	public void displayMenu() {
		MenuRepository repository = MenuRepository.getInstance();
		Collection<Pizza> menu = repository.getMenu();
		if (Objects.isNull(menu) || menu.isEmpty()) {
			System.out.println("No Menu to display");
			return;
		}

		menu.forEach(p -> System.out.println(p));
	}

	public void displayAllPizza() {
		MenuRepository repository = MenuRepository.getInstance();
		Collection<Pizza> menu = repository.getAllPizza();
		if (Objects.isNull(menu) || menu.isEmpty()) {
			System.out.println("No Pizza in shop to display");
			return;
		}

		menu.forEach(p -> System.out.println(p));
	}

	public Double updatePizzaPrice(Integer pizzaId, Double updatedPrice) throws NoPizzaFoundException {
		MenuRepository repository = MenuRepository.getInstance();
		Pizza pizza = repository.getPizza(pizzaId);

		if (Objects.isNull(pizza)) {
			throw new NoPizzaFoundException();
		}
		pizza.setPrice(updatedPrice);
		repository.modifyPizza(pizzaId, pizza);
		return updatedPrice;
	}

	public Pizza savePizza(Pizza pizza) {
		MenuRepository repository = MenuRepository.getInstance();
		return repository.savePizza(pizza);
	}

	public Pizza deletePizza(Integer pizzaId) {
		MenuRepository repository = MenuRepository.getInstance();
		return repository.deletePizza(pizzaId);
	}

	public Pizza addPizzaToMenu(Integer pizzaId) throws NoPizzaFoundException {
		MenuRepository repository = MenuRepository.getInstance();
		Pizza pizza = repository.getPizza(pizzaId);
		if (Objects.isNull(pizza)) {
			throw new NoPizzaFoundException();
		}
		return repository.addPizzaInMenu(pizza);
	}
}
