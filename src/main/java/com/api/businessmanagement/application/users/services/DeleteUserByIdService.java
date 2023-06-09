package com.api.businessmanagement.application.users.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.businessmanagement.infra.database.hibernate.clients.repositories.UserRepository;

@Service
public class DeleteUserByIdService {
	private UserRepository userRepository;
	private GetUserByIdService getUserByIdService;

	public DeleteUserByIdService(
		UserRepository userRepository,
		GetUserByIdService getUserByIdService
	) {
		this.userRepository = userRepository;
		this.getUserByIdService = getUserByIdService;
	}

	public void execute(UUID id) {
		getUserByIdService.execute(id);
		userRepository.deleteById(id);
	}
}
