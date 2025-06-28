package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // or AUTO
    private Long id;
    private String name;

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
