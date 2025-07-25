package com.example.country.service;


import com.example.country.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private static final List<Country> countryList = new ArrayList<>();

    static {
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("UK", "United Kingdom"));
    }

    public List<Country> getAllCountries() {
        return countryList;
    }

    public Country getCountryByCode(String code) {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public Country createCountry(Country country) {
        countryList.add(country);
        return country;
    }

    public Country updateCountry(Country updatedCountry) {
        for (int i = 0; i < countryList.size(); i++) {
            Country c = countryList.get(i);
            if (c.getCode().equalsIgnoreCase(updatedCountry.getCode())) {
                countryList.set(i, updatedCountry);
                return updatedCountry;
            }
        }
        return null;
    }

    public void deleteCountry(String code) {
        countryList.removeIf(c -> c.getCode().equalsIgnoreCase(code));
    }
}

