package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

  
}

