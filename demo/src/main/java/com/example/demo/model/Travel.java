package com.example.demo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
	
	private Integer travelId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer QuantityByAdult;
	private Integer QuantityByChild;
	
	
}
