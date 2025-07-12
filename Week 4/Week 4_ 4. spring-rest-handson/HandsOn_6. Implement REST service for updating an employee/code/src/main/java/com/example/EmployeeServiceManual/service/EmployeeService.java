package com.example.EmployeeServiceManual.service;

import com.example.EmployeeServiceManual.dao.EmployeeDao;
import com.example.EmployeeServiceManual.exception.EmployeeNotFoundException;
import com.example.EmployeeServiceManual.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        dao.updateEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public void addEmployee(Employee e) {
        dao.addEmployee(e);
    }
}
