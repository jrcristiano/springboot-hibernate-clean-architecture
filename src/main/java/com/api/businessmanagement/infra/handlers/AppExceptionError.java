package com.api.businessmanagement.infra.handlers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.api.businessmanagement.infra.handlers.exceptions.BadRequestErrorException;
import com.api.businessmanagement.infra.handlers.exceptions.ConflictErrorException;
import com.api.businessmanagement.infra.handlers.exceptions.EntityNotFoundErrorException;
import com.api.businessmanagement.infra.handlers.responses.ResponseError;

@ControllerAdvice
public class AppExceptionError {
	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ResponseError> handleAllExceptions(
		Exception exception,
		WebRequest request
	) {
		var status = HttpStatus.INTERNAL_SERVER_ERROR;

		var details = new ArrayList<String>();
		details.add(exception.getLocalizedMessage());

		var responseError = new ResponseError()
			.setMessage("Internal Server Error")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = BadRequestErrorException.class)
	public final ResponseEntity<ResponseError> handleBadRequestException(
		Exception exception,
		WebRequest request
	) {
		var status = HttpStatus.BAD_REQUEST;

		var details = new ArrayList<String>();
		details.add(exception.getMessage());

		var responseError = new ResponseError()
			.setMessage("Bad Request")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = EntityNotFoundErrorException.class)
	public final ResponseEntity<ResponseError> handleEntityNotFoundException(
		Exception exception
	) {
		var status = HttpStatus.NOT_FOUND;

		var details = new ArrayList<String>();
		details.add(exception.getMessage());

		var responseError = new ResponseError()
			.setMessage("Not Found")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = ConflictErrorException.class)
	public final ResponseEntity<ResponseError> handleRequestMethodNotSupportedException(
		Exception exception
	) {
		var status = HttpStatus.CONFLICT;

		var details = new ArrayList<String>();
		details.add(exception.getMessage());

		var responseError = new ResponseError()
			.setMessage("Conflict")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}
}
