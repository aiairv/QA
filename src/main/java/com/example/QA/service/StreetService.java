package com.example.QA.service;

import com.example.QA.dto.CityDto;
import com.example.QA.dto.StreetDto;
import com.example.QA.entity.City;
import com.example.QA.entity.Street;
import com.example.QA.repository.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StreetService {
    StreetRepository streetRepository;
    public StreetDto entityToDto(Street street) {
        StreetDto dto = new StreetDto();
        dto.setId(street.getId());
        dto.setStreetName(street.getStreetName());
        dto.setCityId(street.getCityId());
        return dto;
    }
    public List<StreetDto> getAllStreetsByCityId(Long cityId) {
        List<Street> streets = streetRepository.findByCityId(cityId);
        List<StreetDto> dtos = new ArrayList<>();
        for (Street street : streets) {
            dtos.add(entityToDto(street));
        }
        return dtos;
    }
}
