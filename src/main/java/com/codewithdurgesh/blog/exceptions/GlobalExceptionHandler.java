package com.codewithdurgesh.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithdurgesh.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>resourcenotfoundexceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(message , false);
		return new ResponseEntity<>(apiResponse , HttpStatus.NOT_FOUND);
	}

}
