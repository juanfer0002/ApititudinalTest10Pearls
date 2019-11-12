package com.pearls.apititudinaltest.controllers;

import java.util.List;

import com.pearls.apititudinaltest.dto.DatapointDTO;
import com.pearls.apititudinaltest.services.MetricsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping("/city-visits")
    public List<DatapointDTO> getVisitsByCity() {
        return metricsService.getVisitsByCity();
    }

}
