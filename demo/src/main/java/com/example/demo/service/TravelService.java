package com.example.demo.service;

import java.math.BigDecimal;

import org.jvnet.hk2.annotations.Service;

@Service
public class TravelService {
	
	 @Override
	    public Hotels run(Hotels[] hotels, String dateCheckin, String dateCheckout, Long totAdults, Long totChildren) {
	        Hotels hotel = hotels[0];
	        Long numberOfDays = LocalDateUtil.getTotalDoPeridoDeDias(dateCheckin, dateCheckout);
	        BigDecimal accumulatedVal = BigDecimal.ZERO;
	        for(Hotel hotelOther : hotels) {
	            for(Room room : hotelOther.getRooms()) {
	            	
	            	if (room.getPrice() != null) {
	            		accumulatedVal = accumulatedVal.add(room.calcCommission(numberOfDays, totAdults, totChildren));
	            		hotel.getRooms().get(0).setTotalPrice(accumulatedVal);
	            	}
	            }
	        }
	        return hotel;
	    }
}
	
	