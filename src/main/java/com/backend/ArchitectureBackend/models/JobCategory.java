package com.backend.ArchitectureBackend.models;

import javax.persistence.*;

//POJO = Plain Object Java Object
@Entity
@Table(name="job_categories")
public class JobCategory {
    //this is "primary key"
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long id;
    @Column
    private String profilePhoto;

}
