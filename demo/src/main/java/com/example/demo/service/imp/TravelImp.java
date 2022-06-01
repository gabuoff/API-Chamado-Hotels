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

@Service
public class TravelImp implements ServiceImp{
    private Integer adult = 1;
    private Integer child = 1;
    private Long Days = 1l;
    private Travel travel;
	    
	    public TravelImp() {
	    }
	    public TravelImp(Travel dtTravel) {
	        travel =  dtTravel;
	    }
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
	            if(room.getPriceDetail().getAdult()!=null)
	            	pricesDetailDTO.setPricePerDayAdult(new BigDecimal(room.getPriceDetail().getAdult().doubleValue() * Days).setScale(2, RoundingMode.HALF_EVEN));
	           
	            pricesDetailDTO.setPricePerDayChild(new BigDecimal(room.getPriceDetail().getChild().doubleValue() * Days).setScale(2, RoundingMode.HALF_EVEN));

	            roomsDTO.setPricesDetail(pricesDetailDTO);

	            BigDecimal pricePerAdult = new BigDecimal((pricesDetailDTO.getPricePerDayAdult().doubleValue() * adult) / 0.70);
	            BigDecimal pricePerChildren = new BigDecimal((pricesDetailDTO.getPricePerDayChild().doubleValue() * child) / 0.70);

	            roomsDTO.setTotalPrice(pricePerAdult.add(pricePerChildren).setScale(2, RoundingMode.HALF_EVEN));
	            rooms.add(roomsDTO);
	        });
	        hotelDTO.setRooms(rooms);
	        return hotelDTO;
	    }

}
	
	