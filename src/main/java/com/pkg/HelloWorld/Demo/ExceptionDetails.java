package com.pkg.HelloWorld.Demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ExceptionDetails {

	private Date timestamp;
	private String message;
	private String details;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

	public ExceptionDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
