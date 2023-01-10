//package com.backend.ArchitectureBackend.service.Impl;
//import java.util.*;
//
//import com.backend.ArchitectureBackend.models.Job;
//import com.backend.ArchitectureBackend.repositories.ConversationRepository;
//import com.backend.ArchitectureBackend.models.ResponseObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ConversationServiceImpl implements com.backend.ArchitectureBackend.service.ConversationService {
//    @Autowired
//    private ConversationRepository conversationRepository;
//
//    @Override
//    public List<Job> getAllConvos() {
//        return conversationRepository.findAll();
//    }
//
//    @Override
//    public ResponseEntity<ResponseObject> findById(Long id) {
//        Optional<Job> foundConversation = conversationRepository.findById(id);
//        return foundConversation.isPresent() ?
//                ResponseEntity.status(HttpStatus.OK).body(
//                        new ResponseObject("ok", "query Convo successfully", foundConversation)) :
//                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                        new ResponseObject("failed", "Cannot find Convo with id: ", ""));
//    }
//
//    @Override
//    public ResponseEntity<ResponseObject> insertConvo(Job newJob) {
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("ok", "query product successfully", conversationRepository.save(newJob)));
//    }
//
//    @Override
//    public ResponseEntity<ResponseObject> updateConvo(Job newJob, Long id) {
//
//        Job updatedJob = conversationRepository.findById(id).map(job -> {
//            job.setMessageList(newJob.getMessageList());
//            job.setProfilePhoto(newJob.getProfilePhoto());
//            return conversationRepository.save(job);
//        }).orElseGet(() -> {
//            newJob.setId(id);
//            return conversationRepository.save(newJob);
//        });
//
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("ok", "Update user successfully", conversationRepository.save(updatedJob)));
//    };
//
//}
