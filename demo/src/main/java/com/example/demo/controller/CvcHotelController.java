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
				@RequestParam @Valid LocalDate dataCheckIn,
				@RequestParam @Valid LocalDate dataCheckOut,
				@RequestParam @Valid Integer adults, 
				@RequestParam @Valid Integer childs) {
	      
		    List<Hotel> hotelsCVC = uriService.tripAvails(codeCity);
		    travelImp = new TravelImp(new Travel(dataCheckIn, dataCheckOut, adults, childs, hotelsCVC));
			List<HotelDTO> hotels = travelImp.calcAvails();
			
			return ResponseEntity.ok(hotels);

		}
	

	
}
    //@GetMapping(path = "/Travel/{travelId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<HotelDTO>> calcAvails(@PathVariable("codeCity") @Valid Integer codeCity,
//    		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCheckin,
//    		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCheckout,
//			@RequestParam @Valid Integer adults, 
//			@RequestParam @Valid Integer childs){
//    			List<Hotel> hotelCVC = ApiService.hotelAvail(codeCity);
//    			
//    			priceService = new TravelImp(new Travel(dataCheckin, dataCheckout, adults, childs, hotelCVC));
//    			
//    			List<HotelDTO> hotels = priceService.calcAvails();
//    			
//    			return ResponseEntity.ok(hotels);
//	}
//	
//    
//    @GetMapping(path = "/Hotel/{hotelid}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<HotelDTO> calculate(@PathVariable("hotelid") @Valid Integer hotelId){
//		
//		Hotel hotel = ApiService.hotelDetails(hotelId);
//		HotelDTO hotelDTO = priceService.calcDetails(hotel);
//		
//		return ResponseEntity.ok(hotelDTO);
//	} 
    