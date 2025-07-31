package com.cognizant.ormupdate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormupdate.exception.CountryNotFoundException;
import com.cognizant.ormupdate.model.Country;
import com.cognizant.ormupdate.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }

        Country country = result.get();
        country.setName(newName);
        countryRepository.save(country);
    }
}
