package com.api.businessmanagement.presentation.controllers.users;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.businessmanagement.application.users.dto.responses.UserDTO;
import com.api.businessmanagement.application.users.usecases.GetUserByIdUseCase;

@RestController
@RequestMapping("/api/users")
public class GetUserByIdController {

	private final GetUserByIdUseCase getUserByIdUseCase;

	private final Logger logger = Logger.getLogger("UserByIdController ::");

	public GetUserByIdController(GetUserByIdUseCase getUserByIdUseCase) {
		this.getUserByIdUseCase = getUserByIdUseCase;
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> execute(@PathVariable("id") UUID id) {
		var user = getUserByIdUseCase.execute((UUID) id);

		logger.info("USER SHOW SUCCESSFULLY: [GET] api/users/{id}");

		UserDTO userDTO = (UserDTO) new UserDTO().convertToDTO(user);
		return ResponseEntity.ok(userDTO);
	}
}
