package com.qsp.student_management.exceptions;

public class IdNotFound extends RuntimeException{
	
	private String message;

	public IdNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


	

}
