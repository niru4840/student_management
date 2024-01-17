package com.qsp.student_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.student_management.dto.Student;
import com.qsp.student_management.util.StudentResponse;

public class ApplicationException  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(PhoneNotAvailable.class)
	public ResponseEntity<StudentResponse<String>>handlePhoneNotFound(PhoneNotAvailable a){
		
		StudentResponse<String> response = new StudentResponse<String>();
		response.setMessage(a.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setData("Phone not Found");
		return new ResponseEntity<StudentResponse<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<StudentResponse<String>>handleEmailNotFound(EmailNotFound a){
		
		StudentResponse<String> response = new StudentResponse<String>();
		response.setMessage(a.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setData("Email not Found");
		return new ResponseEntity<StudentResponse<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataNotAvailable.class)
	public ResponseEntity<StudentResponse<String>>handlePhoneNotFound(DataNotAvailable a){
		
		StudentResponse<String> response = new StudentResponse<String>();
		response.setMessage(a.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setData("Data Not Found");
		return new ResponseEntity<StudentResponse<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<StudentResponse<String>>handlePhoneNotFound(IdNotFound a){
		
		StudentResponse<String> response = new StudentResponse<String>();
		response.setMessage(a.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setData("Id Not Found");
		return new ResponseEntity<StudentResponse<String>>(response,HttpStatus.NOT_FOUND);
	}

}
