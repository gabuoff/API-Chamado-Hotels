package com.example.calculo.calculo.controller;

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

import com.example.calculo.calculo.domain.Hotel;
import com.example.calculo.calculo.domain.Travel;
import com.example.calculo.calculo.dto.HotelDTO;
import com.example.calculo.calculo.service.impl.UsuarioServiceImpl;
import com.example.calculo.calculo.service.response.ResponseService;

@CrossOrigin("*")
@Validated
@RestController
@RequestMapping(path = "/calculos-avulso", produces = "application/json")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl travelImp;

	@Autowired
	private ResponseService uriService;

	@GetMapping(path = "/avail/{codeCity}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<HotelDTO>> calcAvailscalcAvails(
			@PathVariable("codeCity") @Valid Integer codeCity,
			@RequestParam @Valid String dataCheckIn,
			@RequestParam @Valid String dataCheckOut,
			@RequestParam @Valid BigDecimal adults, 
			@RequestParam @Valid BigDecimal childs) {
		List<Hotel> hotelsCVC = uriService.tripAvails(codeCity);

		LocalDate checkInConverted = LocalDate.parse(dataCheckIn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate checkOutConverted = LocalDate.parse(dataCheckOut, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		travelImp = new UsuarioServiceImpl(new Travel(checkInConverted, checkOutConverted, adults, childs, hotelsCVC));
		List<HotelDTO> hotels = travelImp.calcAvails();

		return ResponseEntity.ok(hotels);

	}

	@GetMapping(path = "/hotel/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HotelDTO> calculate(@PathVariable("hotelId") Integer hotelId) {
		Hotel HotelTripAvails = uriService.avgHotelDetails(hotelId);
		HotelDTO hotelDTO = travelImp.calcHotels(HotelTripAvails);

		return ResponseEntity.ok(hotelDTO);
	}

}
