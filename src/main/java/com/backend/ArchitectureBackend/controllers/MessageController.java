package com.backend.ArchitectureBackend.controllers;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.Message;
import com.backend.ArchitectureBackend.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Messages")
@CrossOrigin(origins = "*")
public class MessageController {
    //DI = Dependency Injection
    @Autowired
    private MessageRepository repository;

    @GetMapping("")
        //this request is: http://localhost:5432/Messages
    List<Message> getAllMessages() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Message> foundMessage = repository.findById(id);
        return foundMessage.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "query product successfully", foundMessage)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find message with id: ", ""));
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertMessage(@RequestBody Message newMessage) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "query product successfully", repository.save(newMessage)));
    }
}
