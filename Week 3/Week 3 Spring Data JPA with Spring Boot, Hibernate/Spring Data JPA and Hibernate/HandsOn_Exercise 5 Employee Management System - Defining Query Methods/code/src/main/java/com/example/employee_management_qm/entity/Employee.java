package com.example.employee_management_qm.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;



import jakarta.persistence.*;

@Entity
@NamedQuery(
    name = "Employee.findByNameLike",
    query = "SELECT e FROM Employee e WHERE e.name LIKE CONCAT('%', :name, '%')"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    // Constructors
    public Employee() {}

    public Employee(String name, String role, Department department) {
        this.name = name;
        this.role = role;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

