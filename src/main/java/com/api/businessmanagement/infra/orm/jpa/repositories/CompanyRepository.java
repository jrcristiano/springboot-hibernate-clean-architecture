package com.api.businessmanagement.infra.orm.jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.businessmanagement.infra.orm.jpa.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

}
