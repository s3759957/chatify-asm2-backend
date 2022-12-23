package com.backend.ArchitectureBackend.repositories;

import com.backend.ArchitectureBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
}
