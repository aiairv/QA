package com.example.QA.dto;

import com.example.QA.entity.City;
import com.example.QA.entity.Street;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ShopDto {
    private Long id;
    private String shopName;
    private City cityId;
    private Street streetId;
    private String houseNumber;
    private LocalTime openTime;
    private LocalTime closeTime;
}
