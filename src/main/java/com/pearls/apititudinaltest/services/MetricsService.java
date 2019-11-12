package com.pearls.apititudinaltest.services;

import java.util.List;

import com.pearls.apititudinaltest.dto.DatapointDTO;
import com.pearls.apititudinaltest.repositories.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    @Autowired
    private VisitRepository visitRepository;

    public List<DatapointDTO> getVisitsByCity() {
        return visitRepository.getVisitsByCityMetrics();
    }

}
