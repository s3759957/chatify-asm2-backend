package com.backend.ArchitectureBackend.controllers;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.Conversation;
import com.backend.ArchitectureBackend.models.User;
import com.backend.ArchitectureBackend.repositories.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Conversations")
@CrossOrigin(origins = "*")
public class ConversationController {
    //DI = Dependency Injection
    @Autowired
    private ConversationRepository repository;

    @GetMapping("")
        //this request is: http://localhost:5432/Conversations
    List<Conversation> getAllConversations() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Conversation> foundConversation = repository.findById(id);
        return foundConversation.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "query product successfully", foundConversation)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find message with id: ", ""));
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertConvo(@RequestBody Conversation newConversation) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "query product successfully", repository.save(newConversation)));
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateConvo(@RequestBody Conversation newConversation, @PathVariable Long id) {

        Conversation updatedConversation = repository.findById(id).map(conversation -> {
            conversation.setMessageList(newConversation.getMessageList());
            conversation.setProfilePhoto(newConversation.getProfilePhoto());
            return repository.save(conversation);
        }).orElseGet(() -> {
            newConversation.setId(id);
            return repository.save(newConversation);
        });

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update user successfully", repository.save(updatedConversation)));
    };

}
