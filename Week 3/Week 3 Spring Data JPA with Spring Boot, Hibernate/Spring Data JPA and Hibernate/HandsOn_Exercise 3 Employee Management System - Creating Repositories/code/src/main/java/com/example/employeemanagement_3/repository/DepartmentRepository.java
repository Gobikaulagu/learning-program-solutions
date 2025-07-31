package com.example.employeemanagement_3.repository;

import com.example.employeemanagement_3.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Optional: find by name
    Department findByName(String name);
}
