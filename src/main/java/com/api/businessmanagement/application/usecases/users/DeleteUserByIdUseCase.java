package com.api.businessmanagement.application.usecases.users;

import com.api.businessmanagement.application.services.users.DeleteUserByIdService;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUserByIdUseCase {
	private final DeleteUserByIdService deleteUserByIdService;

	public DeleteUserByIdUseCase(DeleteUserByIdService deleteUserByIdService) {
		this.deleteUserByIdService = deleteUserByIdService;
	}

	public void execute(UUID id) {
		deleteUserByIdService.execute(id);
	}
}
