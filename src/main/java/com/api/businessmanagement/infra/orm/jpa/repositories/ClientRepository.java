package com.api.businessmanagement.infra.orm.jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.businessmanagement.infra.orm.jpa.entities.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
