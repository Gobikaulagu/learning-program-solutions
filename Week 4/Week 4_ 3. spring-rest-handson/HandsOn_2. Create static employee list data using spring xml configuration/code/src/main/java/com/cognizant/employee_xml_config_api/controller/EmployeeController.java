package com.cognizant.employee_xml_config_api.controller;

import com.cognizant.employee_xml_config_api.dao.EmployeeDao;
import com.cognizant.employee_xml_config_api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
