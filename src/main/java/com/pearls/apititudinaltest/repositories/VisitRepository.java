package com.pearls.apititudinaltest.repositories;

import java.util.List;

import com.pearls.apititudinaltest.dto.DatapointDTO;
import com.pearls.apititudinaltest.model.Visit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {

    List<Visit> findByClientIdOrderByDateDesc(int clientId);

    void deleteByClientId(int clientId);

    @Query("select new com.pearls.apititudinaltest.dto.DatapointDTO(city.name, count(1)) "
            + "from Visit v join v.client c join c.city city group by city.id")
    List<DatapointDTO> getVisitsByCityMetrics();
}
