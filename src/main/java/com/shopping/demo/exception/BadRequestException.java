package com.shopping.demo.exception;

import java.util.List;

import com.shopping.demo.advice.ErrorDetails;

public class BadRequestException extends RuntimeException {
	
	private List<ErrorDetails> errors;

	public BadRequestException(List<ErrorDetails> errors) {
		super();
		this.errors = errors;
	}

	public List<ErrorDetails> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetails> errors) {
		this.errors = errors;
	}

	

}
