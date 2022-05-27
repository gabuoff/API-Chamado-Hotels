package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TravelDTO implements Serializable{
	private Integer travelId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer QuantityByAdult;
	private Integer QuantityByChild;
}
