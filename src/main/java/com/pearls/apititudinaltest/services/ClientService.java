package com.pearls.apititudinaltest.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.pearls.apititudinaltest.common.Utils;
import com.pearls.apititudinaltest.dto.ClientDTO;
import com.pearls.apititudinaltest.dto.VisitDTO;
import com.pearls.apititudinaltest.model.Client;
import com.pearls.apititudinaltest.model.Visit;
import com.pearls.apititudinaltest.repositories.ClientRepository;
import com.pearls.apititudinaltest.repositories.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private VisitRepository visitRepository;

    public List<ClientDTO> getAll() {
        List<Client> entities = clientRepository.findByOrderByName();
        return entities.stream().map(Client::getDTO).collect(Collectors.toList());
    }

    public ClientDTO getById(int id) {
        Optional<Client> optEntity = clientRepository.findById(id);
        return optEntity.isPresent() ? optEntity.get().getDTO() : null;
    }

    public List<VisitDTO> getClientVisitsById(int id) {
        List<Visit> entities = visitRepository.findByClientIdOrderByDateDesc(id);
        return entities.stream().map(Visit::getDTO).collect(Collectors.toList());
    }

    @Transactional
    public ClientDTO save(ClientDTO dto) {
        BigDecimal assignedCredit = this.getCurrentAssignedCredit(dto.getId());

        Client entity = new Client(dto);
        entity.setNit(Utils.encrypt(dto.getNit()));
        clientRepository.save(entity);
        entity.setAssignedCredit(assignedCredit);

        return entity.getDTO();
    }

    @Transactional
    public void delete(int id) {
        Optional<Client> optEntity = clientRepository.findById(id);
        if (optEntity.isPresent()) {
            visitRepository.deleteByClientId(id);
            clientRepository.delete(optEntity.get());
        }
    }

    private BigDecimal getCurrentAssignedCredit(int id) {
        Optional<Client> optEntity = clientRepository.findById(id);
        return optEntity.isPresent() ? optEntity.get().getAssignedCredit() : BigDecimal.ZERO;
    }

}
