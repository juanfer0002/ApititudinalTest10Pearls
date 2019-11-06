package com.pearls.apititudinaltest.repositories;

import java.util.List;

import com.pearls.apititudinaltest.model.Department;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    List<Department> findCitiesByCountryIdOrderByName(int countryId);
}
