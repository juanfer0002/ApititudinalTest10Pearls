package com.pearls.apititudinaltest.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.pearls.apititudinaltest.dto.ClientDTO;
import com.pearls.apititudinaltest.model.Client;
import com.pearls.apititudinaltest.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAll() {
        List<Client> entities = clientRepository.findByOrderByName();
        return entities.stream().map(Client::getDTO).collect(Collectors.toList());
    }

    @Transactional
    public ClientDTO save(ClientDTO dto) {
        BigDecimal assignedCredit = this.getCurrentAssignedCredit(dto.getId());

        Client entity = new Client(dto);
        clientRepository.save(entity);
        entity.setAssignedCredit(assignedCredit);

        return entity.getDTO();
    }

    @Transactional
    public void delete(int id) {
        Optional<Client> optEntity = clientRepository.findById(id);
        if (optEntity.isPresent()) {
            clientRepository.delete(optEntity.get());
        }
    }

    private BigDecimal getCurrentAssignedCredit(int id) {
        Optional<Client> optEntity = clientRepository.findById(id);
        return optEntity.isPresent() ? optEntity.get().getAssignedCredit() : BigDecimal.ZERO;
    }

}
