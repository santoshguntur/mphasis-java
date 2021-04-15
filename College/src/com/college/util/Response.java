package com.college.util;

import javax.ws.rs.core.Response.Status;

public class Response {
	private Status status;
	private String message;
	private Throwable e;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Response(Status status, String message, Throwable e) {
		super();
		this.status = status;
		this.message = message;
		this.e = e;
	}
	public Throwable getE() {
		return e;
	}
	public void setE(Throwable e) {
		this.e = e;
	}
	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", e=" + e + "]";
	}
	
	

}
