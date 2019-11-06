package com.pearls.apititudinaltest.services;

import java.util.List;
import java.util.stream.Collectors;

import com.pearls.apititudinaltest.dto.DepartmentDTO;
import com.pearls.apititudinaltest.model.Department;
import com.pearls.apititudinaltest.repositories.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getDepartmentsByCountryId(int countryId) {
        List<Department> entities = departmentRepository.findCitiesByCountryIdOrderByName(countryId);
        return entities.stream().map(Department::getDTO).collect(Collectors.toList());
    }

}
