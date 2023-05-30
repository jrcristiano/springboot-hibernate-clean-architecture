package com.api.businessmanagement.infra.database.hibernate.clients.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.api.businessmanagement.infra.database.hibernate.companies.models.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
@SQLDelete(sql = "UPDATE companies SET deleted = true where id = ?")
@Where(clause = "deleted = false")
public class Client implements Serializable {
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

	// Uma empresa para muitos empresas
	// O param "mappedBy" referencia o nome da propriedade na entity Company
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Company> companies;

	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}

