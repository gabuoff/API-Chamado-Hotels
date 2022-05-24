package com.example.demo.model;

import java.util.List;

public class hotels {
    private Integer id;
    private String name;
    private Integer cityCode;
    private String cityName;
    private List<Rooms> rooms;

    public Integer getId(){
        return id;
    }
    public void setId(Integer Id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getCityCode(){
        return cityCode;
    }
    public void setCityCode(Integer cityCode){
        this.cityCode = cityCode ;
    }
    
    public String getCityName(){
        return cityName;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public List<Rooms> getRooms(){
        return rooms;
    }
    public void setRooms(List<Rooms> rooms){
        this.rooms = rooms;
    }
}

