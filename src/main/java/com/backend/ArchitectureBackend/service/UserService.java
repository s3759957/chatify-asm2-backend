package com.backend.ArchitectureBackend.service;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    ResponseEntity<ResponseObject> findById(@PathVariable Long id);

    ResponseEntity<ResponseObject> insertUser(@RequestBody User newUser);

    ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable Long id);
}
