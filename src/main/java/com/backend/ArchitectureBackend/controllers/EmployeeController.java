package com.backend.ArchitectureBackend.controllers;

import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.Employee;
import com.backend.ArchitectureBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    //DI = Dependency Injection
    @Autowired
    private EmployeeService service;

    @GetMapping("")
        //this request is: http://localhost:5432/Messages
    List<Employee> getAllMessages() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertEmployee(@RequestBody Employee newEmployee) {
        return insertEmployee(newEmployee);
    }
}
