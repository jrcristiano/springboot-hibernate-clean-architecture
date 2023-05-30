package com.api.businessmanagement.application.users.usecases;

import com.api.businessmanagement.application.users.dto.requests.UserUpdateDTO;
import com.api.businessmanagement.application.users.services.UpdateUserService;
import com.api.businessmanagement.infra.database.hibernate.users.models.User;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateUserByIdUseCase {
	private final UpdateUserService updateUserService;

	public UpdateUserByIdUseCase(UpdateUserService updateUserService) {
		this.updateUserService = updateUserService;
	}

	public User execute(UUID id, UserUpdateDTO userUpdateDTO) {
		return updateUserService.execute(id, userUpdateDTO);
	}
}
