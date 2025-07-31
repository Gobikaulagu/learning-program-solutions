package com.example.employeedelete.service;

import com.example.employeedelete.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void deleteEmployee(int id) {
        employeeDao.deleteById(id);
    }
}
