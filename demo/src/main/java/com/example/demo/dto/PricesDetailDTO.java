package com.example.demo.dto;


import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonInclude(Include.NON_NULL)
public class PricesDetailDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5569352923108148136L;
	@JsonProperty("pricePerDayAdult")
	private BigDecimal pricePerDayAdult;
	@JsonProperty("pricePerDayChild")
	private BigDecimal pricePerDayChild;

}
