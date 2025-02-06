package com.prova.mongodb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 5395515760929124205L;
	
	private int statusCode;

	public ApplicationException() {
		super();
	}
	
	public ApplicationException(int statusCode, String message, Throwable exception) {
		super(message, exception);
		this.statusCode = statusCode;
	}
}
