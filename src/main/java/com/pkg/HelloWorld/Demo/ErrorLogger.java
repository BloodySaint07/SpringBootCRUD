package com.pkg.HelloWorld.Demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Error_Logger")
public class ErrorLogger {

	@Id
	@GeneratedValue
	private Integer errorId;
	@Column(name="err_timestamp")
	private Date timestamp;
	@Column(name="err_message")
	private String message;
	@Column(name="err_details")
	private String details;

	public Integer getErrorId() {
		return errorId;
	}

	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}

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

	public ErrorLogger(Integer errorId, Date timestamp, String message, String details) {
		super();
		this.errorId = errorId;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	@Override
	public String toString() {
		return "ErrorLogger [errorId=" + errorId + ", timestamp=" + timestamp + ", message=" + message + ", details="
				+ details + "]";
	}

	public ErrorLogger(Date timestamp, String message, String details) {

		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
