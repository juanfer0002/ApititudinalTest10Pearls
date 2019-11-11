package com.pearls.apititudinaltest.repositories;

import java.util.List;

import com.pearls.apititudinaltest.model.Country;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    List<Country> findByOrderByName();
}
