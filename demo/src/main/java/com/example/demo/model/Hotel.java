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
public class Hotel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -324616485383535073L;

	
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cityName")
	private String cityName;
	@JsonProperty("cityCode")
	private Integer cityCode;
	@JsonProperty("rooms")
	private List<Rooms> rooms;
	

}

