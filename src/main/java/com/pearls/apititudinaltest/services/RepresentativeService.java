package com.pearls.apititudinaltest.services;

import java.util.List;
import java.util.stream.Collectors;

import com.pearls.apititudinaltest.dto.RepresentativeDTO;
import com.pearls.apititudinaltest.model.Representative;
import com.pearls.apititudinaltest.repositories.RepresentativeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentativeService {

    @Autowired
    private RepresentativeRepository representativeRepository;

    public List<RepresentativeDTO> getRepresentatives() {
        List<Representative> entities = representativeRepository.findByOrderByName();
        return entities.stream().map(Representative::getDTO).collect(Collectors.toList());
    }

}
