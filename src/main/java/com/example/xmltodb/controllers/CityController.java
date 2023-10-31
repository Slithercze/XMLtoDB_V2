package com.example.xmltodb.controllers;

import com.example.xmltodb.models.City;
import com.example.xmltodb.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @PostMapping("/saveCities")
    public ResponseEntity<?> saveCities(@RequestBody City city) {
        return ResponseEntity.ok(cityService.saveCities(city));
    }
    @GetMapping("/getCities")
    public ResponseEntity<?> getCities() {
        return ResponseEntity.ok(cityService.getCities());
    }
}
