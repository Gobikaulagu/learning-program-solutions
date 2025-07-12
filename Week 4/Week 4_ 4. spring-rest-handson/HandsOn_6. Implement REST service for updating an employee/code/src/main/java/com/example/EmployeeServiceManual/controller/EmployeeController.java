package com.example.EmployeeServiceManual.controller;

import com.example.EmployeeServiceManual.exception.EmployeeNotFoundException;
import com.example.EmployeeServiceManual.model.Employee;
import com.example.EmployeeServiceManual.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        service.updateEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping
    public void addEmployee(@RequestBody @Valid Employee employee) {
        service.addEmployee(employee);
    }
}
