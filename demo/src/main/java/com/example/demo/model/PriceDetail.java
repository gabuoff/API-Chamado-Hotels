package com.example.demo.model;

import java.math.BigDecimal;

public class PriceDetail {
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
