package com.pearls.apititudinaltest.controllers;

import java.util.List;

import com.pearls.apititudinaltest.dto.CityDTO;
import com.pearls.apititudinaltest.services.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{id}/cities")
    public List<CityDTO> getCities(@PathVariable int id) {
        return cityService.getCitiesByDepartmentId(id);
    }

}
