package com.pearls.apititudinaltest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VisitDTO extends DTO {

    private int id;
    private ClientDTO clientDTO;
    private LocalDate date;
    private RepresentativeDTO representativeDTO;
    private BigDecimal net;
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public RepresentativeDTO getRepresentativeDTO() {
        return representativeDTO;
    }

    public void setRepresentativeDTO(RepresentativeDTO representativeDTO) {
        this.representativeDTO = representativeDTO;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}