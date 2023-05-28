package com.api.businessmanagement.infra.handlers.exceptions;

public class BadRequestErrorException extends RuntimeException {
	static final long serialVersionUID = 1L;

	public BadRequestErrorException(String message) {
		super(message);
	}
}
