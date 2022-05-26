package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HotelsDTO;
import com.example.demo.model.Travel;

@RestController
@RequestMapping(value = "api/calculate", produces = "application/json")
@Api(value = "Rede de Hoteis CVC", tags = {"Hotels"})
public class CvcHotelController {
	@Autowired
	private PrincipalService principalService;
	
	@GetMapping(value = "/city")
	public List<HotelsDTO> calcPerCity(@Valid Travel travel){
		return travelService.cities(travel);
	}
	@GetMapping(value = "/hotel")
	public List<HotelsDTO> calcPerHotel(@Valid Travel travel){
		return travelService.cities(travel);
	}
	
	
}
