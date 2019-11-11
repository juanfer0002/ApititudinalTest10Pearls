package com.pearls.apititudinaltest.services;

import java.util.List;
import java.util.stream.Collectors;

import com.pearls.apititudinaltest.dto.CountryDTO;
import com.pearls.apititudinaltest.model.Country;
import com.pearls.apititudinaltest.repositories.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDTO> getCountries() {
        List<Country> entities = countryRepository.findByOrderByName();
        return entities.stream().map(Country::getDTO).collect(Collectors.toList());
    }

}
