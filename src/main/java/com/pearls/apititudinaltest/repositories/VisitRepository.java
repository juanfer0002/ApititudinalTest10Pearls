package com.pearls.apititudinaltest.repositories;

import java.util.List;

import com.pearls.apititudinaltest.model.Visit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {

    List<Visit> findByClientIdOrderByDateDesc(int clientId);

    void deleteByClientId(int clientId);
}
