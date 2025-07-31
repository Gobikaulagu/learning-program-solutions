package com.example.employeemanagement_2.repository;



import com.example.employeemanagement_2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

