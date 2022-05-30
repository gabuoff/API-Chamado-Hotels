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
	
	    private Integer quantityAdults = 2;
	    private Integer quantityChilds = 1;
	    private Long days = 5l;
	    private Travel travel;
	    
	    public TravelImp() {
	    }

	    public TravelImp(Travel pTravel) {
	        travel = pTravel;
	    }

	    
	    
	    @Override
	    public  List<HotelDTO> calcAvails() {


	    	List<HotelDTO> hotel = new ArrayList<HotelDTO>();


	        return hotel;
	    }

		@Override
	    public HotelDTO calcDetails(Hotel hotel) {
	        
	        HotelDTO hotelDTO = new HotelDTO();
	        
	        hotelDTO.setId(hotel.getId());
	        hotelDTO.setCityName(hotel.getCityName());

	        
	        List<RoomsDTO> rooms = new ArrayList<RoomsDTO>();
	        
	        hotelDTO.getRooms().forEach(room -> {
	            RoomsDTO roomsDTO = new RoomsDTO();
	            roomsDTO.setRoomId(room.getRoomId());
	            roomsDTO.setCategoryName(room.getCategoryName());

	            PricesDetailDTO priceDetailDTO = new PricesDetailDTO();
	            priceDetailDTO.setPricePerDayAdult(new BigDecimal(room.getPriceDetail().getPricePerDayAdult().doubleValue() * days)
	                    .setScale(2, RoundingMode.HALF_EVEN));
	            priceDetailDTO.setPricePerDayChild(new BigDecimal(room.getPriceDetail().getPricePerDayChild().doubleValue() * days)
	                    .setScale(2, RoundingMode.HALF_EVEN));

	            roomsDTO.setPriceDetail(priceDetailDTO);

	            BigDecimal priceAdult = new BigDecimal(
	                    (priceDetailDTO.getPricePerDayAdult().doubleValue() * quantityAdults) / 0.70);
	            BigDecimal priceChilds = new BigDecimal(
	                    (priceDetailDTO.getPricePerDayChild().doubleValue() * quantityChilds) / 0.70);

	            roomsDTO.setTotalPrice(priceAdult.add(priceChilds).setScale(2, RoundingMode.HALF_EVEN));

	            rooms.add(roomsDTO);
	        });

	        hotelDTO.setRooms(rooms);
	        
	        return hotelDTO;
	    }

		

		

}
	
	