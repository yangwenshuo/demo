package com.pyg.entity;

import java.io.Serializable;

public class Result implements Serializable{

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	private boolean success;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
