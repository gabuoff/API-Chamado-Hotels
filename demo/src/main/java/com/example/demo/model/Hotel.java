package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private Integer id;
    private String name;
    private Integer cityCode;
    private String cityName;
    List<Rooms> rooms;

  
}

