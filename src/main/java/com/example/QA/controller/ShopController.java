package com.example.QA.controller;

import com.example.QA.dto.ShopDto;
import com.example.QA.entity.Shop;
import com.example.QA.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ShopController {
    ShopService shopService;

    @PostMapping("/shop")
    ShopDto addNewShop(@RequestBody ShopDto dto) {
        return shopService.addNewShop(dto);

    }

    @GetMapping("/shops")
    public List<Shop> getShops(@RequestParam(required = false) Long streetId,
                               @RequestParam(required = false) Long cityId,
                               @RequestParam(required = false) Boolean isOpen) {
        return shopService.getShops(streetId, cityId, isOpen);
    }
}
