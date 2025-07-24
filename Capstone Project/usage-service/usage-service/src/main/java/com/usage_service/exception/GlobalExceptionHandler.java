package com.usage_service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(UsageLogNotFoundException.class)
	  public ResponseEntity<Map<String,String>> handleNotFound(UsageLogNotFoundException ex) {
	    return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.NOT_FOUND);
	  } 

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException ex) {
	    Map<String,String> errors = new HashMap<>();
	    for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
	      errors.put(fe.getField(), fe.getDefaultMessage());
	    }
	    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	  } 
}
