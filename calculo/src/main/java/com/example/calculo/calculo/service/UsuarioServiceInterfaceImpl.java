package com.example.calculo.calculo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.calculo.calculo.domain.Hotel;
import com.example.calculo.calculo.dto.HotelDTO;

public interface UsuarioServiceInterfaceImpl {
	List<HotelDTO> calcAvails();

	HotelDTO calcDetails(Hotel hotel, LocalDate cheCkin, LocalDate cheCkout, BigDecimal adults, BigDecimal childs);
	HotelDTO calcHotels(Hotel hotel);

}
