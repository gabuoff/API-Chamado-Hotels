package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -941749519867564406L;
	private BigDecimal pricePerDayAdult;
    private BigDecimal pricePerDayChild;
	public BigDecimal getPricePerDayAdult() {
		return pricePerDayAdult;
	}
	public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}
	public BigDecimal getPricePerDayChild() {
		return pricePerDayChild;
	}
	public void setPricePerDayChild(BigDecimal pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}

}
