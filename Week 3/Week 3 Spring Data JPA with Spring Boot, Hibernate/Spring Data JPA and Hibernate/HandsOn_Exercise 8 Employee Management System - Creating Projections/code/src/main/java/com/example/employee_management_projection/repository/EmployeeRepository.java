package com.example.employee_management_projection.repository;

import com.example.employee_management_projection.entity.Employee;
import com.example.employee_management_projection.projection.EmployeeNameRoleProjection;
import com.example.employee_management_projection.projection.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Interface-based
    List<EmployeeNameRoleProjection> findBy();

    // Class-based DTO
    @Query("SELECT new com.example.employee_management_projection.projection.EmployeeDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeDTO> fetchEmployeeWithDepartment();
}
