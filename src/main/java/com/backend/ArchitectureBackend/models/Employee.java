package com.backend.ArchitectureBackend.models;

import javax.persistence.*;
import java.util.*;
import java.sql.Timestamp;
import java.time.Instant;

//POJO = Plain Object Java Object
@Entity
@Table(name="employees")
public class Employee {
    //this is "primary key"
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long id;
    @Column
    private String title;

}