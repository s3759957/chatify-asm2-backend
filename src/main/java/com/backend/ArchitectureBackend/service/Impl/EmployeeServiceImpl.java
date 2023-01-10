package com.backend.ArchitectureBackend.service.Impl;
import java.util.*;

import com.backend.ArchitectureBackend.service.EmployeeService;
import com.backend.ArchitectureBackend.models.ResponseObject;
import com.backend.ArchitectureBackend.models.Employee;
import com.backend.ArchitectureBackend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "query Message successfully", foundEmployee)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find product with id: ", ""));
    }

    @Override
    public ResponseEntity<ResponseObject> insertEmployee(Employee newEmployee) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "query product successfully", employeeRepository.save(newEmployee)));
    }


}
