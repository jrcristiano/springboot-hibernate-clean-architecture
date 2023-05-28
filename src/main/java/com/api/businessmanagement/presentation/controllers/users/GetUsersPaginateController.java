package com.api.businessmanagement.presentation.controllers.users;

import java.util.logging.Logger;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.businessmanagement.application.dto.responses.users.UserDTO;
import com.api.businessmanagement.application.usecases.users.GetUsersPaginateUseCase;

@RestController
@RequestMapping("/api/users")
public class GetUsersPaginateController {

	private final GetUsersPaginateUseCase getUsersPaginateUseCase;

	private final Logger logger = Logger.getLogger("UserPaginateController ::");

	public GetUsersPaginateController(GetUsersPaginateUseCase getUsersPaginateUseCase) {
		this.getUsersPaginateUseCase = getUsersPaginateUseCase;
	}

	@GetMapping
	public Page<UserDTO> execute(
		@RequestParam(name = "page", required = false, defaultValue = "1") String page,
		@RequestParam(name = "limit", required = false, defaultValue = "10") String limit,
		@RequestParam(name = "orderBy", required = false, defaultValue = "desc") String orderBy,
		@RequestParam(name = "sortBy", required = false, defaultValue = "createdAt") String sortBy
	) {
		var users = getUsersPaginateUseCase.execute(
			page,
			limit,
			orderBy,
			sortBy
		);

		logger.info("USER LIST SUCCESSFULLY: [GET] api/users");

		return users.map(user -> new UserDTO().convertToDTO(user));
	}
}
