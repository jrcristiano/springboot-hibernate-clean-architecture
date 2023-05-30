package com.api.businessmanagement.infra.orm.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true where id = ?")
@Where(clause = "deleted = false")
@Getter
@Setter
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name", nullable = false, length = 32)
	private String name;

	@Column(name = "lastname", nullable = false, length = 128)
	private String lastname;

	@Column(name = "email", nullable = false, length = 255, unique = true)
	private String email;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@ManyToOne
	private Company company;

	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
