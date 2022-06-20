package com.example.demo.dto;


import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
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
