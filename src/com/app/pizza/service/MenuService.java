package com.app.pizza.service;

import com.app.pizza.exception.NoPizzaFoundException;
import com.app.pizza.model.Pizza;
import com.app.pizza.repository.MenuRepository;

public interface MenuService {

	public void displayMenu();

	public void displayAllPizza();

	public Double updatePizzaPrice(Integer pizzaId, Double updatedPrice) throws NoPizzaFoundException;

	public Pizza savePizza(Pizza pizza);

	public Pizza deletePizza(Integer pizzaId);

	public Pizza addPizzaToMenu(Integer pizzaId)throws NoPizzaFoundException;

}
