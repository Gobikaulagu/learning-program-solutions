package com.example.EmployeeServiceManual.model;

import jakarta.validation.constraints.*;

public class Skill {

    @NotNull(message = "Skill ID should not be null")
    private Integer id;

    @NotNull(message = "Skill name should not be null")
    @NotBlank(message = "Skill name should not be blank")
    @Size(min = 1, max = 30, message = "Skill name should be between 1 and 30 characters")
    private String name;

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
}
