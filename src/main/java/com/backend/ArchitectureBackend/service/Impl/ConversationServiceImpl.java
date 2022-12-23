package com.backend.ArchitectureBackend.service.Impl;
import java.util.*;

import com.backend.ArchitectureBackend.models.Conversation;
import com.backend.ArchitectureBackend.repositories.ConversationRepository;
import com.backend.ArchitectureBackend.service.UserService;
import com.backend.ArchitectureBackend.models.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class ConversationServiceImpl implements com.backend.ArchitectureBackend.service.ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public List<Conversation> getAllConvos() {
        return conversationRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<Conversation> foundConversation = conversationRepository.findById(id);
        return foundConversation.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "query Convo successfully", foundConversation)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find Convo with id: ", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> insertConvo(Conversation newConversation) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "query product successfully", conversationRepository.save(newConversation)));
    }

    @Override
    public ResponseEntity<ResponseObject> updateConvo(Conversation newConversation, Long id) {

        Conversation updatedConversation = conversationRepository.findById(id).map(conversation -> {
            conversation.setMessageList(newConversation.getMessageList());
            conversation.setProfilePhoto(newConversation.getProfilePhoto());
            return conversationRepository.save(conversation);
        }).orElseGet(() -> {
            newConversation.setId(id);
            return conversationRepository.save(newConversation);
        });

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update user successfully", conversationRepository.save(updatedConversation)));
    };

}
