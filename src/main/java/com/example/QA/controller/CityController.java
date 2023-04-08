package com.example.QA.controller;

import com.example.QA.dto.CityDto;
import com.example.QA.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class CityController {
    CityService cityService;
    @GetMapping("/city")
    List<CityDto> getAllCities(){
        return cityService.getAllCities();
    }
}
