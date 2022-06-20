package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.HotelDTO;
import com.example.demo.model.Hotel;

public interface ServiceImp {

	List<HotelDTO> calcAvails();

	HotelDTO calcDetails(Hotel hotel, LocalDate cheCkin, LocalDate cheCkout, BigDecimal adults, BigDecimal childs);
	HotelDTO calcHotels(Hotel hotel);

}