package com.javanobrain.springbatch.demospringbatchcsv2db.exception;


public class UserNotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserNotfoundException(Integer id) {
		super("User ID not found: " + Integer.toString(id));
	}
	
	public UserNotfoundException() {
		super();
	}

}
