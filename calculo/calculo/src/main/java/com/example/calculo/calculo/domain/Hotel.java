package com.example.calculo.calculo.domain;

import java.io.Serializable;
import java.util.List;

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
public class Hotel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7954785784870467627L;
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
