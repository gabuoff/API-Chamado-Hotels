package com.example.demo.model;

import java.util.List;

public class Rooms {
    private Integer roomId;
    private String categoryName;
    private List<Prices> prices;

    public Integer getRoomId(){
        return roomId;
    }
    public void setRoomId(Integer roomId){
        this.roomId = roomId;
    }
    
    public String getCategoryName(){ 
        return categoryName;
    }
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

}


