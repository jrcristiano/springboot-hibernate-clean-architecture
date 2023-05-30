package com.api.businessmanagement.application.users.usecases;

import com.api.businessmanagement.application.users.services.DeleteUserByIdService;

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
