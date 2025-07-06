package com.cognizant.springlearn.repository;

import com.cognizant.springlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

}
