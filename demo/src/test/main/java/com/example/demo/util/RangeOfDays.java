package com.example.demo.util;

import java.time.Duration;
import java.time.LocalDate;

public class RangeOfDays {
	public static long days(LocalDate checkIn, LocalDate checkOut) {
        return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
    }
}
