package com.example.demo.BrokerApiService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import com.example.demo.model.Hotel;

@Service
public class UriService {
	@Autowired
    private RestTemplate restTemplate;

    @Value("${urlAvail}")
    private String urlAvail;

    @Value("${urlHotels}")
    private String urlHotels;

    public List<Hotel> tripAvails(Integer codeCity) {
        
        final String uri = urlAvail.concat(codeCity.toString());
        ResponseEntity<ArrayList<Hotel>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
                        new ParameterizedTypeReference<ArrayList<Hotel>>() {});

        return responseEntity.getBody();

    }

    public Hotel hotelDetails(Integer idHotel) {
        final String uri = urlHotels.concat(idHotel.toString());
        ResponseEntity<ArrayList<Hotel>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
                        new ParameterizedTypeReference<ArrayList<Hotel>>() {});

        return responseEntity.getBody().get(0);
    }


}
