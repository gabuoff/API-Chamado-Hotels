package com.example.demo.dto;

import java.util.List;

public class HotelDTO {
    private Integer id;
    private String cityName;
    private List<RoomsDTO> rooms;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<RoomsDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomsDTO> rooms) {
		this.rooms = rooms;
	}
}
