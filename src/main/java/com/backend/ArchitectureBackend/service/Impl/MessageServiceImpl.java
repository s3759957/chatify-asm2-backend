package com.backend.ArchitectureBackend.service.Impl;
import java.util.*;

import com.backend.ArchitectureBackend.service.MessageService;
import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.Message;
import com.backend.ArchitectureBackend.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<Message> foundMessage = messageRepository.findById(id);
        return foundMessage.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "query Message successfully", foundMessage)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find product with id: ", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> insertMessage(Message newMessage) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "query product successfully", messageRepository.save(newMessage)));
    }


}
