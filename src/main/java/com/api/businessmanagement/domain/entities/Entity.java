package com.api.businessmanagement.domain.entities;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Entity {
	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;
}
