package com.qsp.student_management.exceptions;

public class PhoneNotAvailable extends RuntimeException {

	private String message;

	public PhoneNotAvailable(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
