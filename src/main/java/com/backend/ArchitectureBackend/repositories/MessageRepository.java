package com.backend.ArchitectureBackend.repositories;

import com.backend.ArchitectureBackend.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
