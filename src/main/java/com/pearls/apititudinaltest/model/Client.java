package com.pearls.apititudinaltest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pearls.apititudinaltest.dto.ClientDTO;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "clients")
public class Client extends Model<ClientDTO> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "nit")
    private String nit;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "maximum_amount")
    private BigDecimal maximumAmount;

    @Column(name = "assigned_credit")
    private BigDecimal assignedCredit;

    @Column(name = "visits_percenage")
    private BigDecimal visitsPercenage;

    public Client() {
    }

    public Client(ClientDTO dto) {
        super(dto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(BigDecimal maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public BigDecimal getAssignedCredit() {
        return assignedCredit;
    }

    public void setAssignedCredit(BigDecimal assignedCredit) {
        this.assignedCredit = assignedCredit;
    }

    public BigDecimal getVisitsPercenage() {
        return visitsPercenage;
    }

    public void setVisitsPercenage(BigDecimal visitsPercenage) {
        this.visitsPercenage = visitsPercenage;
    }

    @Override
    public ClientDTO getDTO() {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(this, dto);

        dto.setCityDTO(this.getCity().getDTO());

        return dto;
    }

}
