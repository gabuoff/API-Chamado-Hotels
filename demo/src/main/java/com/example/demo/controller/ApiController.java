package com.example.demo.controller;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@Validated
@RequestMapping(value = "/hotels", produces = "application/json")
@RestController
public class ApiController {

}