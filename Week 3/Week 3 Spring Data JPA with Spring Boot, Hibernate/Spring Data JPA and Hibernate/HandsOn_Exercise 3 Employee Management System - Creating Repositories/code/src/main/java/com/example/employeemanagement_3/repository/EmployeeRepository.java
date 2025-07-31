package com.example.employeemanagement_3.repository;

import com.example.employeemanagement_3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom derived query: find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Optional: find by name
    List<Employee> findByNameContainingIgnoreCase(String name);
}
