package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TravelDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer codeCity;
	private LocalDate checkin;
	private LocalDate checkout;
	private Integer adults;
	private Integer children;
	

	
}
