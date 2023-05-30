package com.api.businessmanagement.application.users.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.businessmanagement.application.users.dto.requests.UserUpdateDTO;
import com.api.businessmanagement.infra.database.hibernate.clients.repositories.UserRepository;
import com.api.businessmanagement.infra.database.hibernate.users.models.User;
import com.api.businessmanagement.infra.database.hibernate.users.utils.BcryptPassword;

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

		var userEntity = new com.api.businessmanagement.domain.users.entities.User(
			userUpdateDTO.getId(),
			userUpdateDTO.getName(),
			userUpdateDTO.getLastname(),
			userUpdateDTO.getEmail(),
			BcryptPassword.encode(userUpdateDTO.getPassword()),
			null,
			userUpdateDTO.getUpdatedAt()
		);

		var user = getUserByIdService.execute(id);
		BeanUtils.copyProperties(userEntity, user);

		return userRepository.save(user);
	}
}
