package com.backend.ArchitectureBackend.repositories;

import com.backend.ArchitectureBackend.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}
