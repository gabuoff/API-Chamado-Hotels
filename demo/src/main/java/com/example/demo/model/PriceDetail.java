package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PriceDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -941749519867564406L;
	
	@JsonProperty("adult")
	private BigDecimal adult;
	@JsonProperty("child")
	private BigDecimal child;

	
}
