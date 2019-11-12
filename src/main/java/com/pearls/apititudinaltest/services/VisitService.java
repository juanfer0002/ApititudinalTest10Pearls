package com.pearls.apititudinaltest.services;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pearls.apititudinaltest.common.exceptions.CustomValidationException;
import com.pearls.apititudinaltest.dto.VisitDTO;
import com.pearls.apititudinaltest.model.Client;
import com.pearls.apititudinaltest.model.Visit;
import com.pearls.apititudinaltest.repositories.ClientRepository;
import com.pearls.apititudinaltest.repositories.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public VisitDTO save(VisitDTO dto) {
        Client client = this.validateVisitToSaveAndGetClient(dto);

        Visit entity = new Visit(dto);
        visitRepository.save(entity);

        BigDecimal sum = entity.getTotal();
        this.updateAssignedCredit(client, sum);

        return entity.getDTO();
    }

    @Transactional
    public void delete(int id) {
        Optional<Visit> optEntity = visitRepository.findById(id);
        if (optEntity.isPresent()) {
            Visit entity = optEntity.get();
            BigDecimal substract = entity.getTotal().multiply(new BigDecimal("-1"));
            this.updateAssignedCredit(entity.getClient(), substract);
            visitRepository.delete(entity);
        }
    }

    private Client validateVisitToSaveAndGetClient(VisitDTO dto) {
        Optional<Client> optClient = clientRepository.findById(dto.getClientDTO().getId());
        if (!optClient.isPresent()) {
            throw new CustomValidationException("Client doesn't exist.");
        }

        if (dto.getId() != 0) {
            Optional<Visit> optVisit = visitRepository.findById(dto.getId());

            Client client = optClient.get();
            if (optVisit.isPresent() && optVisit.get().getClient().getId() != client.getId()) {
                throw new CustomValidationException("Visit's client can't be updated.");
            }
        }

        return optClient.get();
    }

    private void updateAssignedCredit(Client client, BigDecimal valueToOperate) {
        BigDecimal assignedCredit = client.getAssignedCredit();
        assignedCredit = assignedCredit == null ? BigDecimal.ZERO : assignedCredit;

        BigDecimal newValue = assignedCredit.add(valueToOperate);
        if (newValue.compareTo(client.getMaximumAmount()) > 0) {
            String msg = "Visit cannot be saved. Available credit is inferior than: " + valueToOperate;
            throw new CustomValidationException(msg);
        }

        client.setAssignedCredit(newValue);
        clientRepository.save(client);
    }

}
