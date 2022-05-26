package com.example.demo.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetail {
    private BigDecimal pricePerDayAdult;
    private BigDecimal pricePerDayChild;

}
