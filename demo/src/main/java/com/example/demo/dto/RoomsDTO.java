package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class RoomsDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private Integer roomId;
    private String categoryName;
    private BigDecimal totalPrice;
    private PricesDetailDTO priceDetail;

  
}
