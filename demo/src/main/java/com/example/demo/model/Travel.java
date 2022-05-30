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
	private Integer quantityAdults;
	private Integer quantityChild;

	
}



