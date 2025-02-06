package com.prova.mongodb.exception;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyErrorBody {

	private Date timestamp;
	private int status;
	private String message;
	private String path;
	private String methodType;

	public MyErrorBody(int status, String message, String path, String methodType) {
		this.timestamp = new Date();
		this.status = status;
		this.message = message;
		this.path = path;
		this.methodType = methodType;
	}

}
