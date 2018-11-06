package com.example.exception;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CareerInfotechExceptionHander extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionMessage> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionMessage msg=new ExceptionMessage(new Date(), ex.getMessage(), "somthing wrong");
		return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String message = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
				.collect(Collectors.joining(","));
		ExceptionMessage errorDetails = new ExceptionMessage(new Date(),message,"Validation Failed");
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}


}
