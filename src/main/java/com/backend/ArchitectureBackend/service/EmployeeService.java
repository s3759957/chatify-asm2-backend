package com.backend.ArchitectureBackend.service;

import com.backend.ArchitectureBackend.models.Employee;
import com.backend.ArchitectureBackend.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    ResponseEntity<ResponseObject> findById(Long id);

    ResponseEntity<ResponseObject> insertEmployee(Employee newEmployee);
}
