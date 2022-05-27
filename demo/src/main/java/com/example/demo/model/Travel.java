package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel implements Serializable{
	
	private static final long serialVersionUID = 5759177104589843588L;
	private Integer travelId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer QuantityByAdult;
	private Integer QuantityByChild;
	public Integer getTravelId() {
		return travelId;
	}
	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	public Integer getQuantityByAdult() {
		return QuantityByAdult;
	}
	public void setQuantityByAdult(Integer quantityByAdult) {
		QuantityByAdult = quantityByAdult;
	}
	public Integer getQuantityByChild() {
		return QuantityByChild;
	}
	public void setQuantityByChild(Integer quantityByChild) {
		QuantityByChild = quantityByChild;
	}
	
	
}
