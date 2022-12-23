package com.backend.ArchitectureBackend.database;

import com.backend.ArchitectureBackend.models.Conversation;
import com.backend.ArchitectureBackend.models.Message;
import com.backend.ArchitectureBackend.models.User;

import com.backend.ArchitectureBackend.repositories.ConversationRepository;
import com.backend.ArchitectureBackend.repositories.MessageRepository;
import com.backend.ArchitectureBackend.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, MessageRepository messageRepository, ConversationRepository conversationRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                Message messageA = new Message("asc",false, "asdas", 38L);
                Message messageB = new Message("asc11", "11", 38L);
                Conversation conA = new Conversation("ABC");
//                Conversation conB = new Conversation("qw12e");
                User userA = new User("billie","billie@gmail.com","123123", "");
                logger.info("insert data: "+userRepository.save(userA));
//                logger.info("insert data: "+messageRepository.save(messageA));
//                logger.info("insert data: "+messageRepository.save(messageA));
                logger.info("insert data: "+messageRepository.save(messageB));
                logger.info("insert data: "+conversationRepository.save(conA));
//                logger.info("insert data: "+conversationRepository.save(conB));
            }
        };
    }
}