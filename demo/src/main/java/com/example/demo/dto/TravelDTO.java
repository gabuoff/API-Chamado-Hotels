package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TravelDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer travelId;
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
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer QuantityByAdult;
	private Integer QuantityByChild;
}
