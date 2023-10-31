package com.example.xmltodb.controllers;

import com.example.xmltodb.models.CityParts;
import com.example.xmltodb.services.CityPartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cityParts")
public class CityPartsController {
    private final CityPartsService cityPartsService;

    @PostMapping("/saveCityParts")
    public ResponseEntity<?> saveCityParts(@RequestBody CityParts cityParts) {
        return ResponseEntity.ok(cityPartsService.saveCityParts(cityParts));
    }
}
