package com.rest.hotel.config;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Utils implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static String getRandomString(int i) {
        String theAlphaNumericS;
        StringBuilder builder;
        theAlphaNumericS = "abcdefghijklmnopqrstuvwxyz0123456789"; 
        builder = new StringBuilder(i);
        for (int m = 0; m < i; m++) { 
            int myindex = (int)(theAlphaNumericS.length() * Math.random()); 
            builder.append(theAlphaNumericS.charAt(myindex)); 
        } 
        return builder.toString(); 
    }
	
	public static String getDataHoraMinutosSegundo() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now());
	}
	
	public static boolean isNullOrEmpty( Object o ) {
		if ( o == null ) {
			return true;
		}
		return false;
	}
	
	public static boolean isNullOrEmpty( List<?> o ) {
		if ( o == null || o.isEmpty() ) {
			return true;
		}
		return false;
	}
	
	public static boolean isNullOrEmpty( String o ) {
		if ( o == null || o.equals("") ) {
			return true;
		}
		return false;
	}
}