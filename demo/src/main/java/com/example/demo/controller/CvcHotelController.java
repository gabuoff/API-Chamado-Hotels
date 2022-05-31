package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.example.demo.BrokerApiService.ToBrokerService;
import com.example.demo.dto.HotelDTO;
import com.example.demo.model.Hotel;
import com.example.demo.service.imp.TravelImp;


@CrossOrigin("*")
@Validated
@RestController
@RequestMapping(path = "/cvc/v1/hotels", produces = "application/json")
public class CvcHotelController {

	@Autowired
	private TravelImp priceService;
//	
	@Autowired
    private ToBrokerService toBrokerService;
//	
  
    @GetMapping(path = "/{travelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<HotelDTO>> calcAvails(
			@PathVariable("travelId") @Valid Integer travelId,
			@RequestParam(value = "checkin") @DateTimeFormat(pattern = "dd/MM/yyyy") @Valid String checkIn,
			 @RequestParam(value = "checkout") @DateTimeFormat(pattern = "dd/MM/yyyy") @Valid String checkOut,
			@RequestParam @Valid Integer QuantityAdults, 
			@RequestParam @Valid Integer QuantityChild) {

//    	
//	    List<Hotel> hotelsCVC = toBrokerService.hotelAvail(travelId);
//
//		
//	    priceService = new TravelImp(new Travel(travelId, checkIn,checkOut, QuantityAdults, QuantityChild, hotelsCVC ));
//		

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