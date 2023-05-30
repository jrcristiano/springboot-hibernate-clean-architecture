package com.api.businessmanagement.application.users.usecases;

import com.api.businessmanagement.application.users.services.CreateUserService;
import com.api.businessmanagement.infra.database.hibernate.users.models.User;
import com.api.businessmanagement.application.users.dto.requests.UserCreateDTO;

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
