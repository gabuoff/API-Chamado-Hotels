package com.example.demo.service.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
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
    
    	private static final BigDecimal COMMISSION = new BigDecimal(0.70);    
   
	    public TravelImp() {
	    }
	    public TravelImp(Travel dataTravel) {
	        travel =  dataTravel;
	    }
	    
		private BigDecimal qtdDays = new BigDecimal(0);  
	    
	    @Override
	    public List<HotelDTO> calcAvails() {
	        List<HotelDTO> hotels = new ArrayList<HotelDTO>();
	        	        
	        travel.getHotel().forEach(hotel -> {
	            hotels.add(calcDetails(hotel,travel.getCheckIn(),travel.getCheckOut(),travel.getAdults(),travel.getChildren()));
	        });
	         return hotels;
	    }

	   @Override
	    public HotelDTO calcDetails(Hotel hotel,LocalDate cheCkin,LocalDate cheCkout,BigDecimal adults, BigDecimal childs ) {
	        HotelDTO hotelDTO = new HotelDTO();
	        qtdDays=new BigDecimal(RangeOfDays.days(cheCkin, cheCkout));
	        hotelDTO.setId(hotel.getId());
	        hotelDTO.setCityName(hotel.getCityName());
	        List<RoomsDTO> rooms = new ArrayList<RoomsDTO>();
	        hotel.getRooms().forEach(room -> {
	        	
	            RoomsDTO roomsDTO = new RoomsDTO();
	            roomsDTO.setRoomId(room.getRoomId());
	            roomsDTO.setCategoryName(room.getCategoryName());
	            
	            PricesDetailDTO pricesDetailDTO = new PricesDetailDTO();
		           if(room.getPriceDetail().getAdult()!=null) {
		            	pricesDetailDTO.setPricePerDayAdult(room.getPriceDetail().getAdult().multiply(qtdDays).setScale(2, RoundingMode.HALF_EVEN));
		            	pricesDetailDTO.setPricePerDayChild(room.getPriceDetail().getChild().multiply(qtdDays).setScale(2, RoundingMode.HALF_EVEN));
		           }
	            roomsDTO.setPricesDetail(pricesDetailDTO);
	            BigDecimal pricePerAdult = pricesDetailDTO.getPricePerDayAdult().multiply(adults).divide(COMMISSION, 2, RoundingMode.HALF_UP);
	            BigDecimal pricePerChildren = pricesDetailDTO.getPricePerDayChild().multiply(childs).divide(COMMISSION, 2, RoundingMode.HALF_UP);
	           roomsDTO.setTotalPrice(pricePerAdult.add(pricePerChildren).setScale(2, RoundingMode.HALF_EVEN));
	           
	            rooms.add(roomsDTO);
	        });
	        hotelDTO.setRooms(rooms);
	        return hotelDTO;
	    }
	   
	   public HotelDTO calcHotels(Hotel hotel) {
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
		            	pricesDetailDTO.setPricePerDayAdult(room.getPriceDetail().getAdult().setScale(2, RoundingMode.HALF_EVEN));
		            	pricesDetailDTO.setPricePerDayChild(room.getPriceDetail().getChild().setScale(2, RoundingMode.HALF_EVEN));
		           }
	            roomsDTO.setPricesDetail(pricesDetailDTO);
	            BigDecimal pricePerAdult = pricesDetailDTO.getPricePerDayAdult().divide(COMMISSION, 2, RoundingMode.HALF_UP);
	            BigDecimal pricePerChildren = pricesDetailDTO.getPricePerDayChild().divide(COMMISSION, 2, RoundingMode.HALF_UP);
	           roomsDTO.setTotalPrice(pricePerAdult.add(pricePerChildren).setScale(2, RoundingMode.HALF_EVEN));
	           
	            rooms.add(roomsDTO);
	        });
	        hotelDTO.setRooms(rooms);
	        return hotelDTO;
	    }
	    
	    
}