package com.stock.products.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler
{
	
	@ExceptionHandler( Exception.class)
	public ResponseEntity<Object>exception(Exception exception)
	{
		return new ResponseEntity<>("internal server error",HttpStatus.BAD_REQUEST);	
	}
	
	 
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String>no(NoSuchElementException no)
	{
		return new ResponseEntity<>(" No data at present in database,Please enter valid Id ",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object>ex(ConstraintViolationException ex)
	{
		return new ResponseEntity<>(" Invalid input ",HttpStatus.BAD_REQUEST);
	}
   

@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		 Map<String,String> errors=new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((error) ->{
			 
			 String fieldName=((FieldError)error).getField();
			 String message=error.getDefaultMessage();
			 errors.put(fieldName, message);
		 });
		 return new ResponseEntity<Object>(errors ,HttpStatus.BAD_REQUEST);
	
//	 Map<String, Object> er = new LinkedHashMap<>();
//     er.put("timestamp", new Date());
//     er.put("status", status.value());
//      
// 
//     List<String> errors = ex.getBindingResult()
//             .getFieldErrors().stream()
//            .map(x -> x.getDefaultMessage())
//             .collect(Collectors.toList());
//
//     er.put("errors", errors);
//
//     return new ResponseEntity<>(er, headers, status);

 
}

}
