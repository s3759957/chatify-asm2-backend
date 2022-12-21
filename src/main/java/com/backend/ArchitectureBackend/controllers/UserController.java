package com.backend.ArchitectureBackend.controllers;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.User;
import com.backend.ArchitectureBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/Users")
@CrossOrigin(origins = "*")
public class UserController {
    //DI = Dependency Injection
    @Autowired
    private UserRepository repository;

    @GetMapping("")
        //this request is: http://localhost:5432/Users
    List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<User> foundUser = repository.findById(id);
        return foundUser.isPresent() ?
            ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "query product successfully", foundUser)) :
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product with id: ", ""));
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody User newUser) {
        List<User> foundProducts = repository.findByUserName(newUser.getUserName().trim());
        return foundProducts.size() > 0 ?
            ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "Product name already taken","")):
            ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "query product successfully", repository.save(newUser)));
    }

    @PutMapping("/{id}")
        ResponseEntity<ResponseObject> updateProduct(@RequestBody User newUser, @PathVariable Long id) {
        List<User> foundProducts = repository.findByUserName(newUser.getUserName().trim());
        if (foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "User name already taken",""));
        }

        User updatedUser = repository.findById(id).map(user -> {
            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
            user.setAvatar(newUser.getAvatar());
            user.setEmail(newUser.getEmail());
            user.setStatus(newUser.getStatus());
            user.setOnline(newUser.getOnline());
            user.setDeactivated(newUser.getDeactivated());
            return repository.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return repository.save(newUser);
        });

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update user successfully", repository.save(updatedUser)));
    };

}
