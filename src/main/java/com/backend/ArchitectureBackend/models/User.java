package com.backend.ArchitectureBackend.models;

import javax.persistence.*;
import java.util.*;

//POJO = Plain Object Java Object
@Entity
@Table(name="users")
public class User {
    //this is "primary key"
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long id;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String avatar;
    @Column
    private String status;
    @Column
    private Boolean isOnline;
    @Column
    private Boolean isDeactivated;
    @Column
    private ArrayList<Long> convoList;
    @Column
    private ArrayList<Long> friendList;

    public User() {
        this.status = "";
        this.isOnline = false;
        this.isDeactivated = false;
        this.convoList = new ArrayList<Long>();
        this.friendList = new ArrayList<Long>();
    }

    public User(String userName, String email, String password, String avatar) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.status = "";
        this.isOnline = false;
        this.isDeactivated = false;
        this.convoList = new ArrayList<Long>();
        this.friendList = new ArrayList<Long>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Boolean getDeactivated() {
        return isDeactivated;
    }

    public void setDeactivated(Boolean deactivated) {
        isDeactivated = deactivated;
    }

    public ArrayList<Long> getConvoList() {
        return convoList;
    }

    public void setConvoList(ArrayList<Long> convoList) {
        this.convoList = convoList;
    }

    public ArrayList<Long> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Long> friendList) {
        this.friendList = friendList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status='" + status + '\'' +
                ", isOnline=" + isOnline +
                ", isDeactivated=" + isDeactivated +
                ", convoList=" + convoList +
                ", friendList=" + friendList +
                '}';
    }
}