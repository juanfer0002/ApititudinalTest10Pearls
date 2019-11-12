package com.pearls.apititudinaltest.dto;

import java.math.BigDecimal;

public class DatapointDTO extends DTO {

    private String name;
    private BigDecimal value;

    public DatapointDTO() {
    }

    public DatapointDTO(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public DatapointDTO(String name, long value) {
        this.name = name;
        this.value = BigDecimal.valueOf(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
