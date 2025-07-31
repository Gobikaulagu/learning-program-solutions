package com.cognizant.deletecountry.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    private String co_code;

    private String co_name;

    // Getters and Setters
    public String getCo_code() {
        return co_code;
    }

    public void setCo_code(String co_code) {
        this.co_code = co_code;
    }

    public String getCo_name() {
        return co_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
    }

    @Override
    public String toString() {
        return "Country [code=" + co_code + ", name=" + co_name + "]";
    }
}
