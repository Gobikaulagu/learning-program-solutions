package com.example.employee_management_projection.controller;

import com.example.employee_management_projection.projection.EmployeeDTO;
import com.example.employee_management_projection.projection.EmployeeNameRoleProjection;
import com.example.employee_management_projection.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Interface-based projection
    @GetMapping("/name-role")
    public List<EmployeeNameRoleProjection> getNameAndRole() {
        return employeeRepository.findBy();
    }

    // Class-based or projection using custom query
    @GetMapping("/projection")
    public List<EmployeeDTO> getEmployeeWithDepartmentName() {
        return employeeRepository.fetchEmployeeWithDepartment();
    }
}
