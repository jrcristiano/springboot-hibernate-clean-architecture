package com.api.businessmanagement.presentation.controllers.users;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.businessmanagement.application.dto.requests.users.UserUpdateDTO;
import com.api.businessmanagement.application.dto.responses.users.UserDTO;
import com.api.businessmanagement.application.usecases.users.UpdateUserByIdUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UpdateUserByIdController {
	private final UpdateUserByIdUseCase updateUserByIdUseCase;
	private final Logger logger = Logger.getLogger("UpdateUserByIdController ::");

	public UpdateUserByIdController(UpdateUserByIdUseCase updateUserByIdUseCase) {
		this.updateUserByIdUseCase = updateUserByIdUseCase;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> execute(
		@PathVariable("id") UUID id, @RequestBody @Valid UserUpdateDTO userUpdateDTO
	) {
		var updatedUser = updateUserByIdUseCase.execute(id, userUpdateDTO);

		logger.info("USER UPDATED SUCCESSFULLY: [PUT] api/users/{id}");

		return ResponseEntity.status(HttpStatus.OK).body(
			(UserDTO) new UserDTO().convertToDTO(updatedUser)
		);
	}
}
