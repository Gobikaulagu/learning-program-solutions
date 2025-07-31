package com.example.employeemanagement_3;


import com.example.employeemanagement_3.entity.Department;
import com.example.employeemanagement_3.entity.Employee;
import com.example.employeemanagement_3.repository.DepartmentRepository;
import com.example.employeemanagement_3.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
        return args -> {
            // Save a department
            Department d1 = new Department(null, "IT", null);
            departmentRepo.save(d1);

            // Save an employee in IT department
            Employee e1 = new Employee(null, "Gobika", "gobika@example.com", d1);
            employeeRepo.save(e1);

            System.out.println("Inserted Employee: " + e1);
        };
    }
}

