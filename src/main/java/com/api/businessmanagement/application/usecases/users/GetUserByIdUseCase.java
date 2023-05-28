package com.api.businessmanagement.application.usecases.users;

import com.api.businessmanagement.application.services.users.GetUserByIdService;
import com.api.businessmanagement.infra.orm.jpa.entities.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserByIdUseCase {
	private GetUserByIdService getUserByIdService;

	public GetUserByIdUseCase(GetUserByIdService getUserByIdService) {
		this.getUserByIdService = getUserByIdService;
	}

	public User execute(UUID id) {
		return getUserByIdService.execute(id);
	}
}
