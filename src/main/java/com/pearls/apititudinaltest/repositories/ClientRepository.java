package com.pearls.apititudinaltest.repositories;

import java.util.List;

import com.pearls.apititudinaltest.model.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findByOrderByName();

}
