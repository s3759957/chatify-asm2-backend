package com.backend.ArchitectureBackend.models;

import javax.persistence.*;
import java.util.*;
import java.sql.Timestamp;
import java.time.Instant;

//POJO = Plain Object Java Object
@Entity
@Table(name="messages")
public class Message {
    //this is "primary key"
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long id;
    @Column
    private String content;
    @Column
    private String timeStamp;
    @Column
    private Boolean isSeen;
    @Column
    private String mediaUrl;
    @Column
    private Long senderId;

    Timestamp instant= Timestamp.from(Instant.now());

    public Message() {
        this.timeStamp = instant.toString();
        this.isSeen = false;
    }

    public Message(String content, String mediaUrl, Long senderId) {
        this.content = content;
        this.timeStamp = instant.toString();
        this.isSeen = false;
        this.mediaUrl = mediaUrl;
        this.senderId = senderId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", isSeen=" + isSeen +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", senderId='" + senderId + '\'' +
                '}';
    }
}