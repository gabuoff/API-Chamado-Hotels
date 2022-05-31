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
	
    private Integer adults = 1;
    private Integer childs = 1;
    private Long diffDays = 1l;
    private Travel travel;
	    
	    public TravelImp() {
	    }

	    public TravelImp(Travel pTravel) {
	        travel = pTravel;
	    }

	    
	    
	    @Override
	    public List<HotelDTO> calcAvails() {
	        
	        List<HotelDTO> hotels = new ArrayList<HotelDTO>();

	        travel.getHotels().forEach(hotel -> {
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
	            roomsDTO.setRoomId(room.getRoomID());
	            roomsDTO.setCategoryName(room.getCategoryName());

	            PricesDetailDTO pricesDetailDTO = new PricesDetailDTO();
	            pricesDetailDTO.setPricePerDayAdult(new BigDecimal(room.getPriceDetail().getAdult().doubleValue() * diffDays)
	                    .setScale(2, RoundingMode.HALF_EVEN));
	            pricesDetailDTO.setPricePerDayChild(new BigDecimal(room.getPriceDetail().getChild().doubleValue() * diffDays)
	                    .setScale(2, RoundingMode.HALF_EVEN));

	            roomsDTO.setPricesDetail(pricesDetailDTO);

	            BigDecimal priceKickbackAdult = new BigDecimal((pricesDetailDTO.getPricePerDayAdult().doubleValue() * adults) / 0.70);
	            BigDecimal priceKickbackChilds = new BigDecimal((pricesDetailDTO.getPricePerDayChild().doubleValue() * childs) / 0.70);

	            roomsDTO.setTotalPrice(priceKickbackAdult.add(priceKickbackChilds).setScale(2, RoundingMode.HALF_EVEN));

	            rooms.add(roomsDTO);
	        });

	        hotelDTO.setRooms(rooms);
	        
	        return hotelDTO;
	    }

		

		

}
	
	