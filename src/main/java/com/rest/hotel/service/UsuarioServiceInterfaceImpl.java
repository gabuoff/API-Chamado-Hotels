package com.rest.hotel.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.rest.hotel.domain.Hotel;
import com.rest.hotel.dto.HotelDTO;

public interface UsuarioServiceInterfaceImpl {
	List<HotelDTO> calcAvails();

	HotelDTO calcDetails(Hotel hotel, LocalDate cheCkin, LocalDate cheCkout, BigDecimal adults, BigDecimal childs);
	HotelDTO calcHotels(Hotel hotel);

}
