package com.person.exception;

public class PersonNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	public PersonNotFoundException(String message) {
		super(message);
	}
}
