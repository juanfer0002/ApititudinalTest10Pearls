package com.pearls.apititudinaltest.dto;

import java.math.BigDecimal;

public class ClientDTO extends DTO {

    private int id;
    private CityDTO cityDTO;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private BigDecimal maximumAmount;
    private BigDecimal assignedCredit;
    private BigDecimal visitsPercenage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

}