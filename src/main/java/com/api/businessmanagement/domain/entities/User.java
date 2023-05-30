package com.api.businessmanagement.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class User extends Entity {
	private UUID id;
	private String name;
	private String lastname;
	private String email;
	private String password;

	public User(
		UUID id,
		String name,
		String lastname,
		String email,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User(
		UUID id,
		String name,
		String lastname,
		String email,
		String password,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}

		return this.id;
	}

	public String getName() {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public String getLastname() {
		return lastname.substring(0, 1).toUpperCase() + lastname.substring(1).toLowerCase();
	}

	public String getEmail() {
		return email.toLowerCase();
	}

	public String getPassword() {
		return password;
	}
}
