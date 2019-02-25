package com.javanobrain.springbatch.demospringbatchcsv2db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value = UserNotfoundException.class)
	public ResponseEntity<Object> exception(UserNotfoundException notFoundException) {
		return new ResponseEntity<>(String.format("Http Status [%s] --> User not found", HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
		
	}

}
