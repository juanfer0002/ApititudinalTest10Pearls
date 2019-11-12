package com.pearls.apititudinaltest.controllers;

import java.util.List;

import com.pearls.apititudinaltest.dto.RepresentativeDTO;
import com.pearls.apititudinaltest.services.RepresentativeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/representatives")
public class RepresentativeController {

    @Autowired
    private RepresentativeService representativeService;

    @GetMapping
    public List<RepresentativeDTO> getRepresentatives() {
        return representativeService.getRepresentatives();
    }

}
