package com.pearls.apititudinaltest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pearls.apititudinaltest.dto.CountryDTO;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "countries")
public class Country extends Model<CountryDTO> {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public CountryDTO getDTO() {
        CountryDTO dto = new CountryDTO();
        BeanUtils.copyProperties(this, dto);

        return dto;
    }
}
