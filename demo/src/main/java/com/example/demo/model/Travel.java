package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Travel{ 

    @JsonProperty("hotel")
	private List<Hotel> hotel;
    @JsonProperty("checkIn")
	private LocalDate checkIn;
    @JsonProperty("checkOut")
    private LocalDate checkOut;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("children")
    private Integer children;
    
	
	public Travel(LocalDate  checkInConverted, LocalDate  checkOutConverted, Integer dataAdults, Integer dataChilds, List<Hotel> dataHotels) {
		checkIn = checkInConverted;
		checkIn = checkOutConverted;
		adults = dataAdults;
		children = dataChilds;
		hotel = dataHotels;
	}



	
}



