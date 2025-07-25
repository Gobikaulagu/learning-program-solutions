package com.example.employee_management_projection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.employee_management_projection.repository.DepartmentRepository;
import com.example.employee_management_projection.entity.Employee;
import com.example.employee_management_projection.entity.Department;
import com.example.employee_management_projection.repository.EmployeeRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementProjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementProjectionApplication.class, args);
    }@Bean
        public CommandLineRunner dataLoader(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
            return args -> {
                Department dept = new Department();
                dept.setName("IT");
                departmentRepository.save(dept);

                Employee emp1 = new Employee();
                emp1.setName("Abi");
                emp1.setRole("Developer");
                emp1.setDepartment(dept);

                Employee emp2 = new Employee();
                emp2.setName("Kamal");
                emp2.setRole("HR");
                emp2.setDepartment(dept);

                employeeRepository.save(emp1);
                employeeRepository.save(emp2);
            };
       
}
}
