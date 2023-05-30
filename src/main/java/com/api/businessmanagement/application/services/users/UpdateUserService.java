package com.api.businessmanagement.application.services.users;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.businessmanagement.application.dto.requests.users.UserUpdateDTO;
import com.api.businessmanagement.infra.orm.jpa.entities.User;
import com.api.businessmanagement.infra.orm.jpa.repositories.UserRepository;
import com.api.businessmanagement.infra.utils.BcryptPassword;

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

		var encodedPassword = BcryptPassword.encode(userUpdateDTO.getPassword());

		var userEntity = new com.api.businessmanagement.domain.entities.User(
			userUpdateDTO.getId(),
			userUpdateDTO.getName(),
			userUpdateDTO.getLastname(),
			userUpdateDTO.getEmail(),
			encodedPassword,
			userUpdateDTO.getCreatedAt(),
			userUpdateDTO.getUpdatedAt()
		);

		var user = getUserByIdService.execute(id);
		BeanUtils.copyProperties(userEntity, user);

		return user;
	}
}
