package com.api.businessmanagement.presentation.controllers.users;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.businessmanagement.application.usecases.users.DeleteUserByIdUseCase;

@RestController
@RequestMapping("/api/users")
public class DeleteUserByIdController {
	private final DeleteUserByIdUseCase deleteUserByIdUseCase;
	private final Logger logger = Logger.getLogger("UpdateUserByIdController ::");

	public DeleteUserByIdController(DeleteUserByIdUseCase deleteUserByIdUseCase) {
		this.deleteUserByIdUseCase = deleteUserByIdUseCase;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> execute(@PathVariable("id") UUID id) {
		deleteUserByIdUseCase.execute(id);

		logger.info("USER DELETE SUCCESSFULLY: [DELETE] api/users/{id}");

		return ResponseEntity.noContent().build();
	}
}
