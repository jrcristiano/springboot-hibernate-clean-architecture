package com.api.businessmanagement.infra.handlers;

import java.util.ArrayList;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.businessmanagement.infra.handlers.exceptions.BadRequestErrorException;
import com.api.businessmanagement.infra.handlers.exceptions.ConflictErrorException;
import com.api.businessmanagement.infra.handlers.exceptions.EntityNotFoundErrorException;

@ControllerAdvice
public class AppExceptionError extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = BadRequestErrorException.class)
	public final ResponseEntity<ResponseError> handleBadRequestException(
		BadRequestErrorException ex,
		WebRequest request
	) {
		var status = HttpStatus.BAD_REQUEST;

		var details = new ArrayList<String>();
		details.add(ex.getMessage());

		var responseError = new ResponseError()
			.setMessage("Bad Request")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = EntityNotFoundErrorException.class)
	public final ResponseEntity<ResponseError> handleEntityNotFoundException(EntityNotFoundErrorException ex) {
		var status = HttpStatus.NOT_FOUND;

		var details = new ArrayList<String>();
		details.add(ex.getMessage());

		var responseError = new ResponseError()
			.setMessage("Not Found")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@ExceptionHandler(value = ConflictErrorException.class)
	public final ResponseEntity<ResponseError> handleConflictErrorException(ConflictErrorException ex) {
		var status = HttpStatus.CONFLICT;

		var details = new ArrayList<String>();
		details.add(ex.getMessage());

		var responseError = new ResponseError()
			.setMessage("Conflict")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatusCode status,
			WebRequest request
	) {
		var result = ex.getBindingResult();
		var fieldErrors = result.getFieldErrors();

		var errors = new ArrayList<String>();
		for (FieldError error : fieldErrors) {
			errors.add(error.getDefaultMessage());
		}

		var responseError = new ResponseError()
			.setDetails(errors)
			.setMessage("Validation Failed");

		return handleExceptionInternal(ex, responseError, headers, status, request);
	}

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
}
