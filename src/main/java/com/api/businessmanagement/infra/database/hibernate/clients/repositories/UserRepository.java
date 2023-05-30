package com.api.businessmanagement.infra.database.hibernate.clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.businessmanagement.infra.database.hibernate.users.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

	@Query(value = "select * from users where email = :email", nativeQuery = true)
	Optional<User> findUserByEmail(@Param("email") String email);

}
