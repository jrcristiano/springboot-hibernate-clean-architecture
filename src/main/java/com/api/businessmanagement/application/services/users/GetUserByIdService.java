package com.api.businessmanagement.application.services.users;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.businessmanagement.infra.handlers.exceptions.EntityNotFoundErrorException;
import com.api.businessmanagement.infra.orm.jpa.entities.User;
import com.api.businessmanagement.infra.orm.jpa.repositories.UserRepository;

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
