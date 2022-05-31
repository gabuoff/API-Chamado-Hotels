package com.example.demo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Hotel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -324616485383535073L;

	private Integer id;
	private String name;
	private String cityName;
	private Integer cityCode;
	private List<Rooms> rooms;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public List<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}
	
	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
  
}
}

