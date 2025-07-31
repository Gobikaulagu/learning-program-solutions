package com.example.employee_management_qm.repository;


import com.example.employee_management_qm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
