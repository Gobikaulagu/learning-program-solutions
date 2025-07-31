package com.example.employeemanagement_2.repository;


import com.example.employeemanagement_2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

