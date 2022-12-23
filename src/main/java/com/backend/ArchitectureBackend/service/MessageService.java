package com.backend.ArchitectureBackend.service;

import com.backend.ArchitectureBackend.models.Message;
import com.backend.ArchitectureBackend.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();

    ResponseEntity<ResponseObject> findById(Long id);

    ResponseEntity<ResponseObject> insertMessage(Message newMessage);
}
