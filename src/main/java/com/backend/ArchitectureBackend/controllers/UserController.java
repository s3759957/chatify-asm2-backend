package com.backend.ArchitectureBackend.controllers;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.User;
import com.backend.ArchitectureBackend.repositories.UserRepository;
import com.backend.ArchitectureBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserController {
    //DI = Dependency Injection
    @Autowired
    UserService service;


    @GetMapping("")
        //this request is: http://localhost:5432/Users
    List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return service.findById(id);
        }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertUser(@RequestBody User newUser) {
        return service.insertUser(newUser);
    }

    @PutMapping("/{id}")
        ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return service.updateUser(newUser, id);
    };

}
