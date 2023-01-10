package com.backend.ArchitectureBackend.service.Impl;
import java.util.*;

import com.backend.ArchitectureBackend.service.UserService;
import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.User;
import com.backend.ArchitectureBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "query product successfully", foundUser)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find product with id: ", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> insertUser(User newUser) {
        List<User> foundUsers = userRepository.findByEmail(newUser.getEmail().trim());
        return foundUsers.size() > 0 ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Email already taken","")):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "query user successfully", userRepository.save(newUser)));
    }

    @Override
    public ResponseEntity<ResponseObject> updateUser(User newUser, Long id) {
        List<User> foundUsers = userRepository.findByEmail(newUser.getEmail().trim());
//        if (foundUsers.size() > 0) {
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("failed", "Email already taken",""));
//        }

        User updatedUser = userRepository.findById(id).map(user -> {
            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
            if (foundUsers.size() == 0) user.setEmail(newUser.getEmail());
            user.setStatus(newUser.getStatus());
            return userRepository.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return userRepository.save(newUser);
        });

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update user successfully", userRepository.save(updatedUser)));
    };


}
