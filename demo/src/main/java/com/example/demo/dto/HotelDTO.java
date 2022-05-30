package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3475272990990463009L;
	private Integer id;
    private String cityName;
    private List<RoomsDTO> rooms;

  
}
