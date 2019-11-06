package com.pearls.apititudinaltest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pearls.apititudinaltest.dto.DepartmentDTO;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "departments")
public class Department extends Model<DepartmentDTO> {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public DepartmentDTO getDTO() {
        DepartmentDTO dto = new DepartmentDTO();
        BeanUtils.copyProperties(this, dto);

        return dto;
    }

    public DepartmentDTO getComplexDTO() {
        DepartmentDTO dto = this.getDTO();
        dto.setCountryDTO(this.getCountry().getDTO());

        return dto;
    }
}
