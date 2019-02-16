package com.app.pizza.exception;

public class NoPizzaFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPizzaFoundException() {
		super();
	}

	public NoPizzaFoundException(String message) {
		super(message);
	}

	public NoPizzaFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
