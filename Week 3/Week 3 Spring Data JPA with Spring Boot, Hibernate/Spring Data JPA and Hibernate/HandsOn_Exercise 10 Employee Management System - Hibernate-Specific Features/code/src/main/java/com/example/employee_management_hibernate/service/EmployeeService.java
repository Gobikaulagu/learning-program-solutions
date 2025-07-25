package com.example.employee_management_hibernate.service;

import com.example.employee_management_hibernate.entity.Employee;
import com.example.employee_management_hibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> saveAll(List<Employee> employees) {
        return employeeRepository.saveAll(employees); // triggers batch insert
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
