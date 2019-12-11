package com.bus.Exception;

public class BusLineNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public BusLineNotFoundException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public BusLineNotFoundException() {
		super();
	}

}
