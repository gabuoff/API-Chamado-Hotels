package com.example.demo.util;


import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class LocalDateAttributeConverter {

	public static LocalDate convertStringToLocalDate(String date){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}
}