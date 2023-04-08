package com.example.QA.service;

import com.example.QA.dto.ShopDto;
import com.example.QA.entity.City;
import com.example.QA.entity.Shop;
import com.example.QA.entity.Street;
import com.example.QA.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopService {
    ShopRepository shopRepository;
    StreetService streetService;
    CityService cityService;

    public ShopDto addNewShop(ShopDto dto) {
        Shop shop = new Shop();
        shop.setShopName(dto.getShopName());
        shop.setCityId(dto.getCityId());
        shop.setStreetId(dto.getStreetId());
        shop.setHouseNumber(dto.getHouseNumber());
        shop.setOpenTime(dto.getOpenTime());
        shop.setCloseTime(dto.getCloseTime());
        shop = shopRepository.save(shop);
        dto.setId(shop.getId());
        return dto;

    }


    public List<Shop> getShops(Long streetId, Long cityId, Boolean isOpen) {
        List<Shop> shops = shopRepository.findAll();
        if (streetId != null) {
            Street street = streetService.getById(streetId);

            if(street.getId() != null) {
                shops = shops.stream()
                        .filter(s -> s.getStreetId().getStreetName().equals(street.getStreetName()))
                        .collect(Collectors.toList());
            }
        }
        if (cityId != null) {
            City city = cityService.getById(cityId);

            if (city.getId() != null) {
                shops = shops.stream()
                        .filter(s -> s.getCityId().getCityName().equals(city.getCityName()))
                        .collect(Collectors.toList());
            }
        }

        if (isOpen) {
            List<Shop> shopsIsOpen = new ArrayList<>();

            for (Shop s : shops) {
                LocalTime openTime = s.getOpenTime();
                LocalTime closeTime = s.getCloseTime();
                if (closeTime.isAfter(LocalTime.now()) && openTime.isBefore(LocalTime.now())) {
                    shopsIsOpen.add(s);
                }
            }
            return shopsIsOpen;
        }
        return shops;
    }

}
