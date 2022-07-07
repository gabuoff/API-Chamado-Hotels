package com.example.calculo.calculo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class RoomsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2275733252714528509L;
	private Integer roomId;
	private String categoryName;
	private BigDecimal totalPrice;
	private PricesDetailDTO pricesDetail;

	
  
}
