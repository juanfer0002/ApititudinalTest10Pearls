package com.pearls.apititudinaltest.services;

import java.util.List;
import java.util.stream.Collectors;

import com.pearls.apititudinaltest.dto.CityDTO;
import com.pearls.apititudinaltest.model.City;
import com.pearls.apititudinaltest.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> getCitiesByDepartmentId(int departmentId) {
        List<City> entities = cityRepository.findByDepartmentIdOrderByName(departmentId);
        return entities.stream().map(City::getDTO).collect(Collectors.toList());
    }

}
