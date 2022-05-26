package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Rooms;

public class HotelsDTO {
    private Integer id;
    private String cityName;
    private List<Rooms> rooms;

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

    public List<Rooms> getRooms(){
        return rooms;
    };

    public void setRooms(List<Rooms> rooms){
        this.rooms = rooms;
    }
}
