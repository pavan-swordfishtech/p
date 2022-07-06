package com.exossystems.api.exceptions;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExosExceptionInterceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ExosExternalServiceInvocationException.class)
	public final ResponseEntity<Object> handleAllExceptions(ExosExternalServiceInvocationException ex) {
		// TODO: do the logging extend whatever we extra needed and create more types if
		// needed
		return new ResponseEntity<Object>(new ExosExceptionSchema(ex.getMessage(), UUID.randomUUID()),
				HttpStatus.BAD_GATEWAY);
	}

}
