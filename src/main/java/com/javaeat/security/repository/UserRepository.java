package com.javaeat.security.repository;

import com.javaeat.security.enums.Role;
import com.javaeat.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}