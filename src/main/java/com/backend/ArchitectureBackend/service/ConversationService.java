package com.backend.ArchitectureBackend.service;

import com.backend.ArchitectureBackend.models.Conversation;
import com.backend.ArchitectureBackend.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConversationService {
    List<Conversation> getAllConvos();

    ResponseEntity<ResponseObject> findById(Long id);

    ResponseEntity<ResponseObject> insertConvo(Conversation newConversation);

    ResponseEntity<ResponseObject> updateConvo(Conversation newConversation, Long id);
}
