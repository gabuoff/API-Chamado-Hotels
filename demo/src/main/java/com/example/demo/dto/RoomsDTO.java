package com.example.demo.dto;


import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomsDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1081097628067142374L;
	private Integer roomId;
	private String categoryName;
	private BigDecimal totalPrice;
	private PricesDetailDTO pricesDetail;

	
  
}
