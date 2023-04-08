package com.example.QA.controller;

import com.example.QA.dto.StreetDto;
import com.example.QA.service.StreetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping
public class StreetController {
    StreetService streetService;

    @GetMapping("/city/{cityId}/street")
    List<StreetDto> getAllStreetsByCityId(@PathVariable Long cityId) {
        return streetService.getAllStreetsByCityId(cityId);
    }
}