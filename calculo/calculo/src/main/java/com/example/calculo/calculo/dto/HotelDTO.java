package com.example.calculo.calculo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class HotelDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5229695107917716012L;
	private Integer id;
	private String cityName;
	private List<RoomsDTO> rooms;
}
