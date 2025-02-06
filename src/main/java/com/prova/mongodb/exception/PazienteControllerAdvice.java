package com.prova.mongodb.exception;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prova.mongodb.controller.PazienteController;
import com.prova.mongodb.utils.Constants;

@ControllerAdvice(basePackageClasses = PazienteController.class)
public class PazienteControllerAdvice extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(
				new MyErrorBody(status.value(), ex.getMessage(), request.getServletPath(), request.getMethod()),
				status);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (code == null) {
			ApplicationException ex = (ApplicationException) request.getAttribute(Constants.DEFAULT_ERROR_ATTRIBUTES);
			code = ex.getStatusCode();
		}
		HttpStatus status = HttpStatus.resolve(code);
		return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
