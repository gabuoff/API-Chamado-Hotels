package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

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
	private Integer id;
    private String name;
    private Integer cityCode;
    private String cityName;
    List<Rooms> rooms;
	
  
}

