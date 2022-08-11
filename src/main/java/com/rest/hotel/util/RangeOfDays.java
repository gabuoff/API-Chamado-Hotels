package com.rest.hotel.util;

import java.time.Duration;
import java.time.LocalDate;

import lombok.Data;

@Data
public class RangeOfDays {
	
	private long days;
	
	public static long days(LocalDate checkIn, LocalDate checkOut) {
        return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
    }
}
