package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Rooms implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -160391855426550256L;
	
	@JsonProperty("roomID")
	private Integer roomId;
	@JsonProperty("categoryName")
	private String categoryName;
	@JsonProperty("price")
	private PriceDetail priceDetail;

}


