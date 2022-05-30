package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer travelId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer QuantityByAdult;
	private Integer QuantityByChild;
}
