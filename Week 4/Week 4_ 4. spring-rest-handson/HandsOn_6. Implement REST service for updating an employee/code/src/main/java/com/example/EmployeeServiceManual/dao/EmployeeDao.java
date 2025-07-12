package com.example.EmployeeServiceManual.dao;

import com.example.EmployeeServiceManual.exception.EmployeeNotFoundException;
import com.example.EmployeeServiceManual.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public void updateEmployee(Employee emp) throws EmployeeNotFoundException {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(emp.getId())) {
                EMPLOYEE_LIST.set(i, emp);
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee Not Found");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void addEmployee(Employee e) {
        EMPLOYEE_LIST.add(e);
    }
}
