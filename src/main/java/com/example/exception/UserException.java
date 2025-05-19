package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserException {
	
	@ExceptionHandler(UserDataValidationException.class)
	public ResponseEntity<String> handleInvalidId(UserDataValidationException ex)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException nf)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nf.getMessage());
	}

}
