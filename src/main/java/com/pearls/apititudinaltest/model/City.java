package com.pearls.apititudinaltest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pearls.apititudinaltest.dto.CityDTO;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "cities")
public class City extends Model<CityDTO> {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public CityDTO getDTO() {
        CityDTO dto = new CityDTO();
        BeanUtils.copyProperties(this, dto);

        return dto;
    }

    public CityDTO getComplexDTO() {
        CityDTO dto = this.getDTO();
        dto.setDepartmentDTO(this.getDepartment().getComplexDTO());

        return dto;
    }

}
