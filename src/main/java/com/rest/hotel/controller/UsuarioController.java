package com.rest.hotel.controller;

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
import com.rest.hotel.domain.Hotel;
import com.rest.hotel.domain.Travel;
import com.rest.hotel.dto.HotelDTO;
import com.rest.hotel.service.UsuarioService;
import com.rest.hotel.service.response.ResponseService;


@CrossOrigin("*")
@Validated
@RestController
@RequestMapping(path = "/calculos-avulso", produces = "application/json")
public class UsuarioController {

	@Autowired
	private UsuarioService travelImp;

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

		travelImp = new UsuarioService(new Travel(checkInConverted, checkOutConverted, adults, childs, hotelsCVC));
		List<HotelDTO> hotels = travelImp.calcAvails();

		return ResponseEntity.ok(hotels);

	}

	@GetMapping(path = "/hotel/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HotelDTO> calculate(@PathVariable("hotelId") Integer hotelId) {
		Hotel hotelTripAvails = uriService.avgHotelDetails(hotelId);
		HotelDTO hotelDTO = travelImp.calcHotels(hotelTripAvails);

		return ResponseEntity.ok(hotelDTO);
	}

}
