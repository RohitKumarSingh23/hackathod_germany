package com.api.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponsesStatus> handleUserNotFoundExceptionException(UserNotFoundException details){
		ResponsesStatus response=new ResponsesStatus();
		response.setMessage(details.getLocalizedMessage());
		response.setStatusCode(500);
		return new ResponseEntity<ResponsesStatus>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
