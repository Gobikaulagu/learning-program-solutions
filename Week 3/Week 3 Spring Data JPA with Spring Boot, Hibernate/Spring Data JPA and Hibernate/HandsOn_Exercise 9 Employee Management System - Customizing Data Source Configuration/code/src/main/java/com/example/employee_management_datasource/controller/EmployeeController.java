package com.example.employee_management_datasource.controller;

import com.example.employee_management_datasource.employee.Employee;
import com.example.employee_management_datasource.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }
}
