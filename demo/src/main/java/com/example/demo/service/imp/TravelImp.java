package com.example.demo.service.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.PricesDetailDTO;
import com.example.demo.dto.RoomsDTO;
import com.example.demo.model.Hotel;
import com.example.demo.model.Travel;
import com.example.demo.service.ServiceImp;
import com.example.demo.util.RangeOfDays;

@Service
public class TravelImp implements ServiceImp{
    

		private Travel travel;
    
    	private static final double COMMISSION = 0.70;    
   
	    public TravelImp() {
	    }
	    public TravelImp(Travel dataTravel) {
	        travel =  dataTravel;
	    }
	    
		private Integer adult = 1;
	    private Integer child = 1;
	    private long theDays = 1L;
	    
	    @Override
	    public List<HotelDTO> calcAvails() {
	        List<HotelDTO> hotels = new ArrayList<HotelDTO>();
	        travel.getHotel().forEach(hotel -> {
	            hotels.add(calcDetails(hotel));
	        });
	         return hotels;
	    }
	    


	    @Override
	    public HotelDTO calcDetails(Hotel hotel) {
	        HotelDTO hotelDTO = new HotelDTO();
	        hotelDTO.setId(hotel.getId());
	        hotelDTO.setCityName(hotel.getCityName());
	        List<RoomsDTO> rooms = new ArrayList<RoomsDTO>();
	        hotel.getRooms().forEach(room -> {
	        	
	            RoomsDTO roomsDTO = new RoomsDTO();
	            roomsDTO.setRoomId(room.getRoomId());
	            roomsDTO.setCategoryName(room.getCategoryName());
	            
	            PricesDetailDTO pricesDetailDTO = new PricesDetailDTO();
	           if(room.getPriceDetail().getAdult()!=null) {
	            	pricesDetailDTO.setPricePerDayAdult(new BigDecimal(room.getPriceDetail().getAdult().doubleValue() * RangeOfDays.days(travel.getCheckIn(),travel.getCheckOut())).setScale(2, RoundingMode.HALF_EVEN));
	            	pricesDetailDTO.setPricePerDayChild(new BigDecimal(room.getPriceDetail().getChild().doubleValue() * theDays).setScale(2, RoundingMode.HALF_EVEN));
	           }
	            roomsDTO.setPricesDetail(pricesDetailDTO);
	            BigDecimal pricePerAdult = new BigDecimal(pricesDetailDTO.getPricePerDayAdult().doubleValue() * adult / COMMISSION);
	            BigDecimal pricePerChildren = new BigDecimal(pricesDetailDTO.getPricePerDayChild().doubleValue() * child / COMMISSION);
	           roomsDTO.setTotalPrice(pricePerAdult.add(pricePerChildren).setScale(2, RoundingMode.HALF_EVEN));
	           
	            rooms.add(roomsDTO);
	        });
	        hotelDTO.setRooms(rooms);
	        return hotelDTO;
	    }
	    
	    
}