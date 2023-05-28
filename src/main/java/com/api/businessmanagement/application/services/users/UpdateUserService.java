package com.api.businessmanagement.application.services.users;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.businessmanagement.application.dto.requests.users.UserUpdateDTO;
import com.api.businessmanagement.infra.orm.jpa.entities.User;
import com.api.businessmanagement.infra.orm.jpa.repositories.UserRepository;

@Service
public class UpdateUserService {
	private final UserRepository userRepository;
	private final GetUserByIdService getUserByIdService;

	public UpdateUserService(
		UserRepository userRepository,
		GetUserByIdService getUserByIdService
	) {
		this.userRepository = userRepository;
		this.getUserByIdService = getUserByIdService;
	}

	public User execute(UUID id, UserUpdateDTO userUpdateDTO) {
		userUpdateDTO.setId(id);

		var userEntity = new com.api.businessmanagement.domain.entities.User(
			userUpdateDTO.getId(),
			userUpdateDTO.getName(),
			userUpdateDTO.getLastname(),
			userUpdateDTO.getEmail(),
			userUpdateDTO.getPassword(),
			null,
			null
		);

		var user = getUserByIdService.execute(id);
		BeanUtils.copyProperties(userEntity, user);

		return userRepository.save(user);
	}
}
