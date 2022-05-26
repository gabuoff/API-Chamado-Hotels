package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {
	
    private Integer roomId;
    private String categoryName;
    private BigDecimal totalPrice;
    List<PriceDetail> priceDetail;

}


