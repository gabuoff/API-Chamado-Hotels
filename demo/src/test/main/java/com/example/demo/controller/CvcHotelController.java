package com.example.demo.controller;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BrokerApiService.UriService;
import com.example.demo.dto.HotelDTO;
import com.example.demo.model.Hotel;
import com.example.demo.model.Travel;
import com.example.demo.service.imp.TravelImp;

@CrossOrigin("*")
@Validated
@RestController
@RequestMapping(path = "/v1", produces = "application/json")
public class CvcHotelController {

	@Autowired
	private TravelImp travelImp;

	@Autowired
	private UriService uriService;



	@GetMapping(path = "/calc-avail/{codeCity}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<HotelDTO>> calcAvails(
			@PathVariable("codeCity") @Valid Integer codeCity,
			@RequestParam @Valid String dataCheckIn,
			@RequestParam @Valid String dataCheckOut,
			@RequestParam @Valid BigDecimal adults, 
			@RequestParam @Valid BigDecimal childs) {
		List<Hotel> hotelsCVC = uriService.tripAvails(codeCity);

		LocalDate checkInConverted = LocalDate.parse(dataCheckIn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate checkOutConverted = LocalDate.parse(dataCheckOut, DateTimeFormatter.ofPattern("dd-MM-yyyy"));


		travelImp = new TravelImp(new Travel(checkInConverted, checkOutConverted, adults, childs, hotelsCVC));
		List<HotelDTO> hotels = travelImp.calcAvails();

		return ResponseEntity.ok(hotels);

	}

	@GetMapping(path = "/calc-hotel/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HotelDTO> calculate(@PathVariable("hotelId") @Valid Integer hotelId
			){	
		Hotel HotelTripAvails = uriService.avgHotelDetails(hotelId);
		HotelDTO hotelDTO = travelImp.calcHotels(HotelTripAvails);

		return ResponseEntity.ok(hotelDTO);
	}



}



