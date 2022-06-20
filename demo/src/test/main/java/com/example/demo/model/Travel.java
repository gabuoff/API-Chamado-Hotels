package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Travel{ 

    @JsonProperty("hotel")
	private List<Hotel> hotel;
    @JsonProperty("checkIn")
	private LocalDate checkIn;
    @JsonProperty("checkOut")
    private LocalDate checkOut;
    @JsonProperty("adults")
    private BigDecimal adults;
    @JsonProperty("children")
    private BigDecimal children;
    
	
	public Travel(LocalDate  checkInConverted, LocalDate  checkOutConverted, BigDecimal dataAdults, BigDecimal dataChilds, List<Hotel> dataHotels) {
		checkIn = checkInConverted;
		checkOut = checkOutConverted;
		adults = dataAdults;
		children = dataChilds;
		hotel = dataHotels;
	}



	
}



