package com.backend.ArchitectureBackend.models;

import javax.persistence.*;
import java.util.*;

//POJO = Plain Object Java Object
@Entity
@Table(name="Conversations")
public class Conversation {
    //this is "primary key"
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long id;
    @Column
    private String profilePhoto;
    @Column
    private ArrayList<Long> messageList;

    public Conversation() {
        this.messageList = new ArrayList<Long>();
    }

    public Conversation(String profilePhoto) {
        this.profilePhoto = profilePhoto;
        this.messageList = new ArrayList<Long>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public ArrayList<Long> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Long> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", messageList=" + messageList +
                '}';
    }
}