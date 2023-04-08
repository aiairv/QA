package com.example.QA.service;

import com.example.QA.dto.CityDto;
import com.example.QA.entity.City;
import com.example.QA.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
CityRepository cityRepository;

public CityDto entityToDTo(City city){
    CityDto dto= new CityDto();
    dto.setId(city.getId());
    dto.setCityName(city.getCityName());
    return dto;
}
public List<CityDto> getAllCities(){
    List<City> cities = cityRepository.findAll();
    List<CityDto> dtos = new ArrayList<>();
    for (City city: cities) {
        dtos.add(entityToDTo(city));
    }
    return dtos;
}

    public City getById(Long cityId) {
    return cityRepository.findById(cityId).orElse(new City());
    }
}
