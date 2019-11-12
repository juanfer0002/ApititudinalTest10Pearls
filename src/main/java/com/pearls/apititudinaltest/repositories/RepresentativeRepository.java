package com.pearls.apititudinaltest.repositories;

import java.util.List;

import com.pearls.apititudinaltest.model.Representative;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentativeRepository extends CrudRepository<Representative, Integer> {

    List<Representative> findByOrderByName();
}
