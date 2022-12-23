package com.backend.ArchitectureBackend.controllers;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.Message;
import com.backend.ArchitectureBackend.repositories.MessageRepository;
import com.backend.ArchitectureBackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/messages")
@CrossOrigin(origins = "*")
public class MessageController {
    //DI = Dependency Injection
    @Autowired
    private MessageService service;

    @GetMapping("")
        //this request is: http://localhost:5432/Messages
    List<Message> getAllMessages() {
        return service.getAllMessages();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertMessage(@RequestBody Message newMessage) {
        return insertMessage(newMessage);
    }
}
