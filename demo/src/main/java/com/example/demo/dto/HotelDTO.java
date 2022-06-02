package com.example.demo.dto;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class HotelDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3475272990990463009L;
	private Integer id;
	private String cityName;
	private List<RoomsDTO> rooms;

	
}
