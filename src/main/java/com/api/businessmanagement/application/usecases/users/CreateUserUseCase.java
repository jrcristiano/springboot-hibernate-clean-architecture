package com.api.businessmanagement.application.usecases.users;

import com.api.businessmanagement.application.dto.requests.users.UserCreateDTO;
import com.api.businessmanagement.application.services.users.CreateUserService;
import com.api.businessmanagement.infra.orm.jpa.entities.User;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {
	private final CreateUserService createUserService;

	public CreateUserUseCase(CreateUserService createUserService) {
		this.createUserService = createUserService;
	}

	public User execute(UserCreateDTO userCreateDTO) {
		return createUserService.execute(userCreateDTO);
	}
}
