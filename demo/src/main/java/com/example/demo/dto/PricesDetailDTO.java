package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PricesDetailDTO {
    private BigDecimal pricePerDayAdult;
    private BigDecimal pricePerDayChild;

    public BigDecimal getPricePerDayAdult(BigDecimal pricePerDayAdult){
        return pricePerDayAdult;
    }
    public void setPricePerDayAdult(BigDecimal pricePerDayAdult){
        this.pricePerDayAdult = pricePerDayAdult;
    }

    public BigDecimal getPricePerDayChild(BigDecimal pricePerDayChild){
        return pricePerDayChild;
    }
    public void setPricePerDayChild(BigDecimal pricePerDayChild){
        this.pricePerDayChild = pricePerDayChild;
    }
}
