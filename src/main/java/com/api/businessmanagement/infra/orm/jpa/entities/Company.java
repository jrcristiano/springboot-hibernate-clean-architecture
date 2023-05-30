package com.api.businessmanagement.infra.orm.jpa.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
@SQLDelete(sql = "UPDATE companies SET deleted = true where id = ?")
@Where(clause = "deleted = false")
public class Company implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "corporate_name", nullable = false, length = 128)
	private String corporateName;

	@Column(name = "fantasy_name", nullable = false, length = 128)
	private String fantasyName;

	@Column(name = "document", nullable = false, length = 14)
	private String document;

	@Column(name = "status", nullable = false)
	private int status;

	@Column(name = "contact", nullable = false, length = 16)
	private String contact;

	@Column(name = "responsible_name", nullable = false, length = 32)
	private String responsibleName;

	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	private List<User> users;

	@ManyToOne
	private Client client;

	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
