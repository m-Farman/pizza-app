package com.app.pizza.model;

public class Order {

	private Integer pizzaId;
	private Integer count;

	public Order() {
		super();
	}

	public Order(Integer pizzaId, Integer count) {
		super();
		this.pizzaId = pizzaId;
		this.count = count;
	}

	public Integer getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Order [pizzaId=" + pizzaId + ", count=" + count + "]";
	}

}
