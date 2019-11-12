package com.pearls.apititudinaltest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pearls.apititudinaltest.dto.RepresentativeDTO;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "representatives")
public class Representative extends Model<RepresentativeDTO> {

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
    public RepresentativeDTO getDTO() {
        RepresentativeDTO dto = new RepresentativeDTO();
        BeanUtils.copyProperties(this, dto);

        return dto;
    }
}
