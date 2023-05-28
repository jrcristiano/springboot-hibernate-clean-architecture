package com.api.businessmanagement.infra.handlers.exceptions;

public class ConflictErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConflictErrorException(String message) {
		super(message);
	}
}
