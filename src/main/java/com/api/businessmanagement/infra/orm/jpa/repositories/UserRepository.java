package com.api.businessmanagement.infra.orm.jpa.repositories;

import com.api.businessmanagement.infra.orm.jpa.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

	@Query(value = "SELECT u from User u where u.email = :email")
	Optional<User> findUserByEmail(@Param("email") String email);

}
