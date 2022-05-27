package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HotelDTO;
import com.example.demo.model.Hotel;

public interface ServiceImp {

	List<HotelDTO> calcAvails();
	
	HotelDTO calcDetails(final Hotel hotel);
}
