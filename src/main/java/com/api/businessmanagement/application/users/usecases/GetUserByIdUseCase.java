package com.api.businessmanagement.application.users.usecases;

import com.api.businessmanagement.application.users.services.GetUserByIdService;
import com.api.businessmanagement.infra.database.hibernate.users.models.User;

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
