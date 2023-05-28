package com.api.businessmanagement.application.usecases.users;

import com.api.businessmanagement.application.dto.requests.users.UserUpdateDTO;
import com.api.businessmanagement.application.services.users.GetUserByIdService;
import com.api.businessmanagement.application.services.users.UpdateUserService;
import com.api.businessmanagement.infra.orm.jpa.entities.User;
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
