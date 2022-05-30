package com.example.demo.controller;

import java.time.LocalDate;
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

import com.example.demo.config.LocalDateAttributeConverter;
import com.example.demo.dto.HotelDTO;
import com.example.demo.model.Hotel;
import com.example.demo.model.Travel;
import com.example.demo.service.ToBrokerService;
import com.example.demo.service.imp.TravelImp;

import io.swagger.annotations.ApiParam;


@CrossOrigin("*")
@Validated
@RestController
@RequestMapping(path = "/cvc/v1/hotels", produces = "application/json")
public class CvcHotelController {

	@Autowired
	private TravelImp priceService;
	
	@Autowired
    private ToBrokerService toBrokerService;
	
  
    @GetMapping(path = "/{codecity}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<HotelDTO>> calcAvails(@PathVariable("codeCity") @Valid Integer codeCity,
			@ApiParam(required = true, example = "21/12/1222") @RequestParam @Valid String dataCheckin,
			@ApiParam(required = true, example = "21/12/1212") @RequestParam @Valid String dataCheckout,
			@RequestParam @Valid Integer adults, 
			@RequestParam @Valid Integer childs) {
	    List<Hotel> hotelsAvails = toBrokerService.hotelAvail(codeCity);

    	
   	 LocalDate checkin = LocalDateAttributeConverter.convertStringToLocalDate(dataCheckin);
	    LocalDate checkout = LocalDateAttributeConverter.convertStringToLocalDate(dataCheckout);
	    
	    priceService = new TravelImp(new Travel(checkin, checkout, adults, childs, hotelsAvails));
		List<HotelDTO> hotels = priceService.calcAvails();
		
		return ResponseEntity.ok(hotels);
	}
	
    
    @GetMapping(path = "/{hotelid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<HotelDTO> calculate(@PathVariable("hotelid") @Valid Integer hotelId){
		
		Hotel hotel = toBrokerService.hotelDetails(hotelId);
		HotelDTO hotelDTO = priceService.calcDetails(hotel);
		
		return ResponseEntity.ok(hotelDTO);
	} 
    
}