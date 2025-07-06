package com.example.employee_management_datasource.repository;

import com.example.employee_management_datasource.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
