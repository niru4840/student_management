package com.qsp.student_management.exceptions;

public class DataNotAvailable extends RuntimeException{
	
	private String message;

	public DataNotAvailable(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
