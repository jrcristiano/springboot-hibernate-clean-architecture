package com.api.businessmanagement.infra.handlers.exceptions;

public class ValidationFailedErrorException extends RuntimeException {
	static final long serialVersionUID = 1L;

	public ValidationFailedErrorException(String message) {
		super(message);
	}
}
