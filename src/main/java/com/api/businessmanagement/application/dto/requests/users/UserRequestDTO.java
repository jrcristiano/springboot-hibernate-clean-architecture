package com.api.businessmanagement.application.dto.requests.users;

import com.api.businessmanagement.infra.orm.jpa.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public abstract class UserRequestDTO {
	protected UUID id;

	@NotBlank(message = "The field name is required")
	@Size(min = 3, max = 32, message = "The field name must have between 3 and 32 characters")
	protected String name;

	@NotBlank(message = "The field lastname is required")
	@Size(min = 3, max = 128, message = "The field lastname is required")
	protected String lastname;

	@NotBlank(message = "The field email is required")
	@Email(message = "The field email must be a valid e-mail address")
	@Size(max = 255, message = "The field email is required")
	protected String email;

	@NotBlank(message = "The field password is required")
	@Size(min = 8, max = 255, message = "The field password must have between 8 and 255 characters")
	protected String password;

	protected LocalDateTime updatedAt;

	public UserRequestDTO convertToDTO(User user) {
		var userEntity = new com.api.businessmanagement.domain.entities.User(
			user.getId(),
			user.getName(),
			user.getLastname(),
			user.getEmail(),
			user.getPassword(),
			null,
			null
		);

		this.setId(userEntity.getId());
		this.setName(userEntity.getName());
		this.setLastname(userEntity.getLastname());
		this.setEmail(userEntity.getEmail());

		return this;
	}
}
