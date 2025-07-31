package com.example.employee_management_hibernate.controller;

import com.example.employee_management_hibernate.entity.Employee;
import com.example.employee_management_hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/batch") // <<<<< This maps POST /employees/batch
    public ResponseEntity<String> batchInsert(@RequestBody List<Employee> employees) {
        employeeService.saveAll(employees);
        return ResponseEntity.ok("Batch insert successful!");
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
