package com.api.businessmanagement.infra.database.hibernate.companies.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.businessmanagement.infra.database.hibernate.companies.models.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

}
