package com.api.businessmanagement.infra.handlers.exceptions;

public class EntityNotFoundErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntityNotFoundErrorException(String message) {
		super(message);
	}
}
