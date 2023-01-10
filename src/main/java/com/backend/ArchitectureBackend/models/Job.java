package com.backend.ArchitectureBackend.models;

import javax.persistence.*;
import java.util.*;

//POJO = Plain Object Java Object
@Entity
@Table(name="jobs")
public class Job {
    //this is "primary key"
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long id;
    @Column
    private String profilePhoto;

}
