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
	private String checkIn;
    @JsonProperty("checkOut")
    private String checkOut;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("children")
    private Integer children;
    
	
	public Travel(String dataCheckin, String dataCheckout, Integer dataAdults, Integer dataChilds, List<Hotel> dataHotels) {
		checkIn = dataCheckin;
		checkIn = dataCheckout;
		adults = dataAdults;
		children = dataChilds;
		hotel = dataHotels;
	}



	
}



