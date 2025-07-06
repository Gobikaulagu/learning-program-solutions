package com.cognizant.ormupdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.ormupdate.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
