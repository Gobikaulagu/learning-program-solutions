package com.example.employee_management_pagination.repository;


import com.example.employee_management_pagination.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

