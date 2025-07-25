package com.example.employee_management_qm.service;



import com.example.employee_management_qm.entity.Employee;
import com.example.employee_management_qm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee save(Employee e) {
        return repo.save(e);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public List<Employee> getByName(String name) {
        return repo.findByName(name);
    }

    public List<Employee> getByDept(String dept) {
        return repo.findByDepartmentName(dept);
    }

    public List<Employee> getByRole(String role) {
        return repo.findByRole(role);
    }
}
