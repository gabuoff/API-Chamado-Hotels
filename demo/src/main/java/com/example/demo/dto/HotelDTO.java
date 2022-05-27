package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class HotelDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3475272990990463009L;
	private Integer id;
    private String cityName;
    private List<RoomsDTO> rooms;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<RoomsDTO> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomsDTO> rooms) {
		this.rooms = rooms;
	}

  
}
