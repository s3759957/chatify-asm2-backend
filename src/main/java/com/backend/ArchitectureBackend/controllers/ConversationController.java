//package com.backend.ArchitectureBackend.controllers;
//
//import com.backend.ArchitectureBackend.models.ResponseObject;
//import com.backend.ArchitectureBackend.models.Job;
//import com.backend.ArchitectureBackend.service.ConversationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping(path = "/conversations")
//@CrossOrigin(origins = "*")
//public class ConversationController {
//    //DI = Dependency Injection
//    @Autowired
//    private ConversationService service;
//
//    @GetMapping("")
//        //this request is: http://localhost:5432/Conversations
//    List<Job> getAllConvos() {
//        return service.getAllConvos();
//    }
//
//    @GetMapping("/{id}")
//    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
//        return service.findById(id);
//    }
//
//    @PostMapping("/insert")
//    ResponseEntity<ResponseObject> insertConvo(@RequestBody Job newJob) {
//        return service.insertConvo(newJob);
//    }
//
//    @PutMapping("/{id}")
//    ResponseEntity<ResponseObject> updateConvo(@RequestBody Job newJob, @PathVariable Long id) {
//        return service.updateConvo(newJob, id);
//    };
//
//}
