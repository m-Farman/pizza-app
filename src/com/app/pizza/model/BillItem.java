package com.app.pizza.model;

public class BillItem {

	private String pizzaName;
	private Integer count;
	private Double price;

	public BillItem(String pizzaName, Integer count, Double price) {
		super();
		this.pizzaName = pizzaName;
		this.count = count;
		this.price = price;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BillItem [pizzaName=" + pizzaName + ", count=" + count + ", price=" + price + "]";
	}

}
