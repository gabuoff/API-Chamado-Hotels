package com.example.demo.dto;


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
public class RoomsDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1081097628067142374L;
	private Integer roomId;
	private String categoryName;
	private BigDecimal totalPrice;
	private PricesDetailDTO pricesDetail;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PricesDetailDTO getPricesDetail() {
		return pricesDetail;
	}

	public void setPricesDetail(PricesDetailDTO pricesDetail) {
		this.pricesDetail = pricesDetail;
	}

	
	
	

  
}
