package com.pearls.apititudinaltest.controllers;

import java.util.List;

import com.pearls.apititudinaltest.dto.ClientDTO;
import com.pearls.apititudinaltest.dto.VisitDTO;
import com.pearls.apititudinaltest.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAll() {
        return clientService.getAll();
    }

    @GetMapping
    public ClientDTO getById(@PathVariable int id) {
        return clientService.getById(id);
    }

    @GetMapping("/{id}/visits")
    public List<VisitDTO> getClientVisits(@PathVariable int id) {
        return clientService.getClientVisitsById(id);
    }

    @PostMapping
    public ClientDTO save(@RequestBody ClientDTO dto) {
        return clientService.save(dto);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable int id, @RequestBody ClientDTO dto) {
        dto.setId(id);
        return clientService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        clientService.delete(id);
    }

}
