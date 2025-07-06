package com.example.employee_management_projection.projection;


public class EmployeeDTO {
    private String name;
    private String role;

    public EmployeeDTO(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

