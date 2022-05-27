package br.com.cvc.corp.hotelaria.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HotelDTO;
import com.example.demo.model.Hotel;
import com.example.demo.service.ToBrokerService;
import com.example.demo.service.imp.TravelService;


@CrossOrigin("*")
@Validated
@RestController
@RequestMapping(path = "/api/hotels", produces = "application/json")
public class CvcHotelController {

	@Autowired
	private TravelService priceService;
	
	@Autowired
    private ToBrokerService toBrokerService;
	
  
    @GetMapping(path = "/calc/{codeCity}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<HotelDTO>> calculateAvails(@PathVariable("codeCity") @Valid Integer codeCity,
	
	    List<Hotel> hotelsAvails = toBrokerService.hotelsAvails(codeCity);
	    
	    LocalDate checkin = LocalDateAttributeConverter.convertStringToLocalDate(dataCheckin);
	    LocalDate checkout = LocalDateAttributeConverter.convertStringToLocalDate(dataCheckout);
		
		priceService = new PriceServiceImpl(new Travel(checkin, checkout, adults, childs, hotelsAvails));
		List<HotelDTO> hotels = priceService.calculateAvails();
		
		return ResponseEntity.ok(hotels);
	}
	
    
    @GetMapping(path = "/calc/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HotelDTO> calc(@PathVariable("hotelId") @Valid Integer hotelId{
		
		Hotel hotel = toBrokerService.hotelDetails(hotelId);
		HotelDTO hotelDTO = priceService.calcDetails(hotel);
		
		return ResponseEntity.ok(hotelDTO);
	} 
}