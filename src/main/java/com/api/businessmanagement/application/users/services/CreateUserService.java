package com.api.businessmanagement.application.users.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.businessmanagement.application.users.dto.requests.UserCreateDTO;
import com.api.businessmanagement.infra.database.hibernate.clients.repositories.UserRepository;
import com.api.businessmanagement.infra.database.hibernate.users.models.User;
import com.api.businessmanagement.infra.database.hibernate.users.utils.BcryptPassword;
import com.api.businessmanagement.infra.handlers.exceptions.ConflictErrorException;

@Service
public class CreateUserService {
	private UserRepository userRepository;

	public CreateUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User execute(UserCreateDTO userCreateDTO) {
		var registeredUser = userRepository.findUserByEmail(userCreateDTO.getEmail());

		if (registeredUser.isPresent()) {
			throw new ConflictErrorException("E-mail address already exists.");
		}

		var userEntity = new com.api.businessmanagement.domain.users.entities.User(
			userCreateDTO.getId(),
			userCreateDTO.getName(),
			userCreateDTO.getLastname(),
			userCreateDTO.getEmail(),
			BcryptPassword.encode(userCreateDTO.getPassword()),
			null,
			null
		);

		var user = new User();
		BeanUtils.copyProperties(userEntity, user);

		return user;

		// return userRepository.save(user);
	}
}
