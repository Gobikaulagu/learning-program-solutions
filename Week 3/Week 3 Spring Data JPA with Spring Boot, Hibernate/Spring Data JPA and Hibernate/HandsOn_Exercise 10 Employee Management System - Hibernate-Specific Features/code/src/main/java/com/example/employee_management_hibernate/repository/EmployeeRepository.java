package com.example.employee_management_hibernate.repository;

import com.example.employee_management_hibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
