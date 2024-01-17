package com.qsp.student_management.exceptions;

public class EmailNotFound extends RuntimeException{

	private String message;

	public EmailNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
