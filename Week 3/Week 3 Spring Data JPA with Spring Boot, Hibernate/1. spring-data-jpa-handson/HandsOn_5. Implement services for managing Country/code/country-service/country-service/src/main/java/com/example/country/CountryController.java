package com.example.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getByCode(code);
    }

    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return countryService.getAllByPartialName(name);
    }

    @PostMapping
    public Country add(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country update(@PathVariable String code, @RequestBody Country country) {
        return countryService.updateCountry(code, country);
    }

    @DeleteMapping("/{code}")
    public String delete(@PathVariable String code) {
        boolean deleted = countryService.deleteCountry(code);
        return deleted ? "Deleted" : "Not found";
    }
}

