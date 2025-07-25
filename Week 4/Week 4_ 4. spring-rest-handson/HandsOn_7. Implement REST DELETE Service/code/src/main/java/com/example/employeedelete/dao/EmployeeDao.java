package com.example.employeedelete.dao;

import com.example.employeedelete.exception.EmployeeNotFoundException;
import com.example.employeedelete.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(1, "Gobika", "IT"));
        employeeList.add(new Employee(2, "Rahul", "HR"));
        employeeList.add(new Employee(3, "Sneha", "Finance"));
    }

    public void deleteById(int id) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.getId() == id) {
                iterator.remove();
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    public List<Employee> getAll() {
        return employeeList;
    }
}
