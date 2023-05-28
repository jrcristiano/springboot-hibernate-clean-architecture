package com.api.businessmanagement.presentation.controllers.users;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.businessmanagement.application.dto.requests.users.UserCreateDTO;
import com.api.businessmanagement.application.dto.responses.users.UserDTO;
import com.api.businessmanagement.application.usecases.users.CreateUserUseCase;
import com.api.businessmanagement.infra.handlers.responses.ResponseError;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class CreateUserController {
	private final CreateUserUseCase createUserUseCase;
	private final Logger logger = Logger.getLogger("CreateUserController ::");

	public CreateUserController(CreateUserUseCase createUserUseCase) {
		this.createUserUseCase = createUserUseCase;
	}

	@PostMapping
	public ResponseEntity<?> execute(@RequestBody @Valid UserCreateDTO userCreateDTO, Errors validationErrors) {
		var validationErrorList = validationErrors.getAllErrors();

		if (validationErrorList.size() > 0) {
			var details = new ArrayList<String>();
			var responseError = new ResponseError().setMessage("Validation Failed");

			for (ObjectError validationError : validationErrorList) {
				details.add(validationError.getDefaultMessage());
			}

			responseError.setDetails(details);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
		}

		var createdUser = createUserUseCase.execute(userCreateDTO);

		logger.info("USER CREATED SUCCESSFULLY: [POST] api/users");

		return ResponseEntity.status(HttpStatus.CREATED).body(
			(UserDTO) new UserDTO().convertToDTO(createdUser)
		);
	}
}
