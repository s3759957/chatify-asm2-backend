package com.backend.ArchitectureBackend.repositories;

import com.backend.ArchitectureBackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
