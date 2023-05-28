package com.api.businessmanagement.application.services.users;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.businessmanagement.application.dto.requests.users.UserCreateDTO;
import com.api.businessmanagement.infra.handlers.exceptions.ConflictErrorException;
import com.api.businessmanagement.infra.orm.jpa.entities.User;
import com.api.businessmanagement.infra.orm.jpa.repositories.UserRepository;

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

		var userEntity = new com.api.businessmanagement.domain.entities.User(
			userCreateDTO.getId(),
			userCreateDTO.getName(),
			userCreateDTO.getLastname(),
			userCreateDTO.getEmail(),
			userCreateDTO.getPassword(),
			null,
			null
		);

		var user = new User();
		BeanUtils.copyProperties(userEntity, user);

		return userRepository.save(user);
	}
}
