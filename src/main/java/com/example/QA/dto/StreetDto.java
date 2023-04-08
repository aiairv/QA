package com.example.QA.dto;

import com.example.QA.entity.City;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class StreetDto {
    private Long id;
    private String streetName;
    private City cityId;
}
