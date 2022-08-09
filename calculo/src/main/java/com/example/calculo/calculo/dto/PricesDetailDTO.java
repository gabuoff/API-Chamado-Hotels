package com.example.calculo.calculo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PricesDetailDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5711692406158771232L;
	@JsonProperty("pricePerDayAdult")
	private BigDecimal pricePerDayAdult;
	@JsonProperty("pricePerDayChild")
	private BigDecimal pricePerDayChild;

}
