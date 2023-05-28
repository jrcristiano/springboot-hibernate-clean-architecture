package com.api.businessmanagement.infra.handlers.exceptions;

public class InternalServerErrorException extends RuntimeException {
	static final long serialVersionUID = 1L;

	public InternalServerErrorException(String message) {
		super(message);
	}
}
