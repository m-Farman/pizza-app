package com.app.pizza.exception;

public class PizzaUpdateFailedExcetion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PizzaUpdateFailedExcetion() {
		super();
	}

	public PizzaUpdateFailedExcetion(String message) {
		super(message);
	}

	public PizzaUpdateFailedExcetion(String message, Throwable cause) {
		super(message, cause);
	}

}
