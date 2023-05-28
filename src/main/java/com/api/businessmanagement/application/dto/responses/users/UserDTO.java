package com.api.businessmanagement.application.dto.responses.users;

import java.time.LocalDateTime;
import java.util.UUID;

import com.api.businessmanagement.infra.orm.jpa.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	protected UUID id;

	protected String name;

	protected String lastname;

	protected String email;

	protected LocalDateTime createdAt;

	protected LocalDateTime updatedAt;

	public UserDTO convertToDTO(User user) {
		var userEntity = new com.api.businessmanagement.domain.entities.User(
			user.getId(),
			user.getName(),
			user.getLastname(),
			user.getEmail(),
			user.getCreatedAt(),
			user.getUpdatedAt()
		);

		this.setId(userEntity.getId());
		this.setName(userEntity.getName());
		this.setLastname(userEntity.getLastname());
		this.setEmail(userEntity.getEmail());
		this.setCreatedAt(userEntity.getCreatedAt());
		this.setUpdatedAt(userEntity.getUpdatedAt());

		return this;
	}
}
