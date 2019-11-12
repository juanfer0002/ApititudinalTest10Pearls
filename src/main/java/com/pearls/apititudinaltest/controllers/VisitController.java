package com.pearls.apititudinaltest.controllers;

import com.pearls.apititudinaltest.dto.VisitDTO;
import com.pearls.apititudinaltest.services.VisitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @PostMapping
    public VisitDTO save(@RequestBody VisitDTO dto) {
        return visitService.save(dto);
    }

    @PutMapping("/{id}")
    public VisitDTO update(@PathVariable int id, @RequestBody VisitDTO dto) {
        dto.setId(id);
        return visitService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        visitService.delete(id);
    }

}
