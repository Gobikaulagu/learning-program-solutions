package com.example.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public List<Country> getAllByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, Country updatedCountry) {
        Optional<Country> existing = countryRepository.findById(code);
        if (existing.isPresent()) {
            Country country = existing.get();
            country.setName(updatedCountry.getName());
            return countryRepository.save(country);
        }
        return null;
    }

    public boolean deleteCountry(String code) {
        if (countryRepository.existsById(code)) {
            countryRepository.deleteById(code);
            return true;
        }
        return false;
    }
}

