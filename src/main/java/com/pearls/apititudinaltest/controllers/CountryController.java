package com.pearls.apititudinaltest.controllers;

import java.util.List;

import com.pearls.apititudinaltest.dto.CountryDTO;
import com.pearls.apititudinaltest.dto.DepartmentDTO;
import com.pearls.apititudinaltest.services.CountryService;
import com.pearls.apititudinaltest.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<CountryDTO> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/{id}/departments")
    public List<DepartmentDTO> getCountries(@PathVariable int id) {
        return departmentService.getDepartmentsByCountryId(id);
    }
}
