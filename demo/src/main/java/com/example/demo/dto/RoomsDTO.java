package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class RoomsDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1081097628067142374L;
	private Integer roomId;
    private String categoryName;
    private BigDecimal totalPrice;
    private PricesDetailDTO priceDetail;
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
	public PricesDetailDTO getPriceDetail() {
		return priceDetail;
	}
	public void setPriceDetail(PricesDetailDTO priceDetail) {
		this.priceDetail = priceDetail;
	}
	

  
}
