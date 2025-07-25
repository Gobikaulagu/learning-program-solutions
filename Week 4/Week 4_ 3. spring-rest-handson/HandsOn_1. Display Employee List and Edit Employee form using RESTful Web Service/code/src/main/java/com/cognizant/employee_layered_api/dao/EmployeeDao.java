package com.cognizant.employee_layered_api.dao;

import com.cognizant.employee_layered_api.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeDao {

    public List<Employee> getAllEmployees() {
        return Arrays.asList(
                new Employee(1, "John", 50000),
                new Employee(2, "Emma", 60000),
                new Employee(3, "Alex", 70000)
        );
    }

    public Employee getEmployeeById(int id) {
        return getAllEmployees().stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
