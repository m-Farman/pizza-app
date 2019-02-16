package com.app.pizza.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.app.pizza.model.Pizza;

public class MenuRepository {

	AtomicInteger pizzaIdGenerator = new AtomicInteger();

	private final Map<Integer, Pizza> pizzas = new ConcurrentHashMap<>();
	private final Map<Integer, Pizza> menu = new ConcurrentHashMap<>();
	private static MenuRepository instance;

	private MenuRepository() {
	}

	public static MenuRepository getInstance() {
		if (instance == null) {
			instance = new MenuRepository();
		}
		return instance;
	}

	public Pizza addPizzaInMenu(Pizza pizza) {
		return this.menu.put(pizza.getId(), pizza);
	}

	public Pizza deletePizza(Integer pizzaId) {
		return this.menu.remove(pizzaId);
	}

	public Pizza modifyPizza(Integer pizzaId, Pizza pizza) {
		return this.pizzas.put(pizzaId, pizza);
	}

	public Pizza getPizza(Integer pizzaId) {
		return this.pizzas.get(pizzaId);
	}

	public Pizza savePizza(Pizza pizza) {
		int id = pizzaIdGenerator.incrementAndGet();
		pizza.setId(id);
		return this.pizzas.put(id, pizza);
	}

	public Collection<Pizza> getMenu() {
		return  menu.values();
	}

	public  Collection<Pizza> getAllPizza() {
		return  pizzas.values();
	}

}
