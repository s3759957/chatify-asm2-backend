package com.backend.ArchitectureBackend.controllers;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.Conversation;
import com.backend.ArchitectureBackend.models.User;
import com.backend.ArchitectureBackend.repositories.ConversationRepository;
import com.backend.ArchitectureBackend.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/conversations")
@CrossOrigin(origins = "*")
public class ConversationController {
    //DI = Dependency Injection
    @Autowired
    private ConversationService service;

    @GetMapping("")
        //this request is: http://localhost:5432/Conversations
    List<Conversation> getAllConvos() {
        return service.getAllConvos();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertConvo(@RequestBody Conversation newConversation) {
        return service.insertConvo(newConversation);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateConvo(@RequestBody Conversation newConversation, @PathVariable Long id) {
        return service.updateConvo(newConversation, id);
    };

}
