package com.poshbike.core.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends
		ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { IllegalArgumentException.class,
			IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(
			IllegalArgumentException ex, WebRequest request) {
		
		log.error(ex.getMessage(), ex);

		return new ResponseEntity<Object>(new RestError(HttpStatus.CONFLICT, 1,
				ex.getMessage() == null ? "INTERNAL_SERVER_ERROR"
						: ex.getMessage(), "IllegalArgumentException"),
				HttpStatus.CONFLICT);

	}

	@ExceptionHandler(value = { NullPointerException.class })
	protected ResponseEntity<Object> handleNullPointer(NullPointerException ex,
			WebRequest request) {
		log.error(ex.getMessage(), ex);

		return new ResponseEntity<Object>(new RestError(HttpStatus.NOT_FOUND,
				4, ex.getMessage() == null ? "INTERNAL_SERVER_ERROR"
						: ex.getMessage(), "NullPointerException"),
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = { RuntimeException.class })
	protected ResponseEntity<Object> handleRuntimeException(
			RuntimeException ex, WebRequest request) {
		log.error(ex.getMessage(), ex);

		return new ResponseEntity<Object>(new RestError(
				HttpStatus.INTERNAL_SERVER_ERROR, 4,
				ex.getMessage() == null ? "INTERNAL_SERVER_ERROR" : ex
						.getMessage(), "RuntimeException"),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
			Object body, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute("javax.servlet.error.exception", ex,
					WebRequest.SCOPE_REQUEST);
		}
		log.error(ex.getMessage(), ex);

		return new ResponseEntity<Object>(new RestError(status, 9,
				"INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR"), status);
	}

}
