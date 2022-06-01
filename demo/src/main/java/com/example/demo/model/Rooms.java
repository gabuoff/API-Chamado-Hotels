package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -160391855426550256L;
	
	@JsonProperty("roomId")
	private Integer roomId;
	@JsonProperty("categoryName")
	private String categoryName;
	@JsonProperty("price")
	private PriceDetail priceDetail;

}


