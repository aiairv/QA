package com.example.QA.service;

import com.example.QA.dto.ShopDto;
import com.example.QA.entity.Shop;
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


    public List<Shop> getShops(String street, String city, Boolean isOpen) {
        List<Shop> shops = shopRepository.findAll();
        if (street != null) {
            shops = shops.stream()
                    .filter(s -> s.getStreetId().getStreetName().equals(street))
                    .collect(Collectors.toList());
        }
        if (city != null) {
            shops = shops.stream()
                    .filter(s -> s.getCityId().getCityName().equals(city))
                    .collect(Collectors.toList());
        }

        if (isOpen) {
            List<Shop> shopsIsOpen = new ArrayList<>();

            for (Shop s : shops) {
                LocalTime openTime = s.getOpenTime();
                LocalTime closeTime = s.getCloseTime();
                if (closeTime.isBefore(LocalTime.now()) && openTime.isAfter(LocalTime.now())) {
                    shopsIsOpen.add(s);
                }
            }
            return shopsIsOpen;
        }
        return shops;
    }

}
