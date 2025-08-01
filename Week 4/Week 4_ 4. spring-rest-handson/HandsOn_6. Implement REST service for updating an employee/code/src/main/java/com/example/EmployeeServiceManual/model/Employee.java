package com.example.EmployeeServiceManual.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class Employee {

    @NotNull(message = "Employee ID should not be null")
    private Integer id;

    @NotNull(message = "Name should not be null")
    @NotBlank(message = "Name should not be blank")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    private String name;

    @NotNull(message = "Salary should not be null")
    @Min(value = 0, message = "Salary should be zero or above")
    private Double salary;

    @NotNull(message = "Permanent status should not be null")
    private Boolean permanent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotNull(message = "Department should not be null")
    private Department department;

    @NotNull(message = "Skills should not be null")
    private List<Skill> skills;

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }
    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
