package com.pkg.HelloWorld.Demo;

import java.util.Date;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.*;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

		ExceptionDetails exceptionesponse = new ExceptionDetails(new Date(), ex.getMessage(),
				request.getDescription(false));

		System.out.println("Inside CustomExceptionHandler Class and handleAllException method");

		return new ResponseEntity(exceptionesponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotAvailableException(Exception ex, WebRequest request) throws Exception {

		ExceptionDetails exceptionesponse = new ExceptionDetails(new Date(), ex.getMessage(),
				request.getDescription(false));

		System.out.println("Inside CustomExceptionHandler Class and handleUserNotAvailableException method");

		return new ResponseEntity(exceptionesponse, HttpStatus.NOT_FOUND);

	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionDetails exceptionesponse = new ExceptionDetails(new Date(), "Validation Failure",
				ex.getBindingResult().toString());

		System.out.println("Inside CustomExceptionHandler Class and handleMethodArgumentNotValid method");

		return new ResponseEntity(exceptionesponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
