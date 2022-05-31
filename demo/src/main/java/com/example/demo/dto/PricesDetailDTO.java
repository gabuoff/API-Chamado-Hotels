package com.example.demo.dto;


import java.io.Serializable;
import java.math.BigDecimal;



public class PricesDetailDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5569352923108148136L;
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
