package com.example.employee_management_qm.repository;



import com.example.employee_management_qm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query
    List<Employee> findByName(String name);

    // Custom JPQL query
    @Query("SELECT e FROM Employee e WHERE e.department.name = ?1")
    List<Employee> findByDepartmentName(String deptName);

    // Named query (from entity)
    List<Employee> findByRole(String role);
}

