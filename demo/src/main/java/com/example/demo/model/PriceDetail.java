package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -941749519867564406L;
	private BigDecimal adult;
	private BigDecimal child;

	public BigDecimal getAdult() {
		return adult;
	}

	public void setAdult(BigDecimal adult) {
		this.adult = adult;
	}

	public BigDecimal getChild() {
		return child;
	}

	public void setChild(BigDecimal child) {
		this.child = child;
	}
	
}
