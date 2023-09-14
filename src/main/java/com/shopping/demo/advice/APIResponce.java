package com.shopping.demo.advice;

public class APIResponce {

	private Integer status;
	private Object errors;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getError() {
		return errors;
	}

	public void setError(Object errors) {
		this.errors = errors;
	}

	public APIResponce() {
		super();
		this.status = 100;
		this.errors = errors;
	}

}
