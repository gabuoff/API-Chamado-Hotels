package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Hotel;

@Service
public class ToBrokerService {
	  @Autowired
	    private RestTemplate restTemplate;


	    @Value("${urlBrokerSeachHotels}")
	    private String urlHotels;
	    
	    @Value("${urlSeachBrokerAvail}")
	    private String urlAvail;

	    public Hotel DetailsByHotel(Integer hotelId) {
	        final String uri = urlHotels.concat(hotelId.toString());
	        ResponseEntity<ArrayList<Hotel>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
	                        new ParameterizedTypeReference<ArrayList<Hotel>>() {});

	        return responseEntity.getBody().get(0);
	    }
	    

	    public List<Hotel> hotelsAvails(Integer codeCity) {
	        
	        final String uri = urlAvail.concat(codeCity.toString());
	        ResponseEntity<ArrayList<Hotel>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
	                        new ParameterizedTypeReference<ArrayList<Hotel>>() {});

	        return responseEntity.getBody();

	    }
}
