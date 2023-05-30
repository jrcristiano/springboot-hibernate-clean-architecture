package com.api.businessmanagement.application.users.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.businessmanagement.infra.database.hibernate.clients.repositories.UserRepository;
import com.api.businessmanagement.infra.database.hibernate.users.models.User;
import com.api.businessmanagement.infra.handlers.exceptions.EntityNotFoundErrorException;

@Service
public class GetUserByIdService {
	private UserRepository userRepository;

	public GetUserByIdService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User execute(UUID id) {
		var user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new EntityNotFoundErrorException("User ID " + id.toString() + " not found.");
		}

		return user.get();
	}
}
