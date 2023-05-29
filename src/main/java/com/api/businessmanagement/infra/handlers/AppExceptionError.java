package com.api.businessmanagement.infra.handlers;

import java.util.ArrayList;

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
import com.api.businessmanagement.infra.handlers.responses.ResponseError;

@ControllerAdvice
public class AppExceptionError extends ResponseEntityExceptionHandler {
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
		Exception exception,
		WebRequest request
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
		Exception exception,
		WebRequest request
	) {
		var status = HttpStatus.CONFLICT;

		var details = new ArrayList<String>();
		details.add(exception.getMessage());

		var responseError = new ResponseError()
			.setMessage("Conflict")
			.setDetails(details);

		return new ResponseEntity<ResponseError>(responseError, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

			var result = ex.getBindingResult();
			var fieldErrors = result.getFieldErrors();

			var errors = new ArrayList<String>();
			for (FieldError error : fieldErrors) {
				errors.add(error.getDefaultMessage());
			}

			var responseError = new ResponseError().setDetails(errors).setMessage("Teste");

		return handleExceptionInternal(ex, responseError, headers, status, request);
	}

	// @ExceptionHandler(value = ValidationFailedErrorException.class)
	// public ResponseEntity<ResponseError> handleValidationExceptions(MethodArgumentNotValidException ex) {
	// 	var details = new ArrayList<String>();

	// 	for (ObjectError error : ex.getBindingResult().getAllErrors()) {
	// 		details.add(error.getDefaultMessage());
	// 	}

	// 	var responseError = new ResponseError()
	// 		.setMessage("Failed")
	// 		.setDetails(details);

	// 	return new ResponseEntity<ResponseError>(responseError, HttpStatus.BAD_REQUEST);
	// }

	// @Override
	// protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	// 	var details = new ArrayList<String>();
	// 	details.add(ex.getMessage());

	// 	var responseError = new ResponseError()
	// 		.setMessage("Conflict")
	// 		.setDetails(details);

	// 	return new ResponseEntity<Object>(responseError, status);
	// 	// try {
	// 		// 	List<String> details = new ArrayList<String>();

	// 		// 	for (ObjectError error : ex.getBindingResult().getAllErrors()) {
	// 		// 		details.add(error.toString());
	// 		// 	}

	// 		// 	// Create a response object with error details
	// 		// 	var responseError = new ResponseError()
	// 		// 		.setMessage("Failed")
	// 		// 		.setDetails(details);


	// 		// 	// super.handleMethodArgumentNotValid(ex, headers, status, request);

	// 		// 	return new ResponseEntity<Object>(responseError, status);
	// 		// } catch (Exception exc) {
	// 		// 	System.out.println("########################################################## CAI AQUI 1");
	// 		// 	var responseError = new ResponseError();
	// 		// 	return new ResponseEntity<Object>(responseError, status);
	// 		// }
	// }

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

	// @Override
	// @Nullable
	// protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
	// 		HttpStatusCode status, WebRequest request) {
	// 	// TODO Auto-generated method stub
	// 	return super.handleMethodArgumentNotValid(ex, headers, status, request);
	// }
}
