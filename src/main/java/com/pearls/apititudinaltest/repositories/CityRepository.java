package com.pearls.apititudinaltest.repositories;

import java.util.List;

import com.pearls.apititudinaltest.model.City;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    List<City> findCitiesByDepartmentIdOrderByName(int departmentId);

}
