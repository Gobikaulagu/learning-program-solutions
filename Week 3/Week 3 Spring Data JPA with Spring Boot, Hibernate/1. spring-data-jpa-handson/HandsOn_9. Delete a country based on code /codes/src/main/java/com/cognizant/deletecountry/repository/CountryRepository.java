package com.cognizant.deletecountry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.deletecountry.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
