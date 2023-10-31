package com.example.xmltodb.services.impl;

import com.example.xmltodb.models.CityParts;
import com.example.xmltodb.repositories.CityPartsRepository;
import com.example.xmltodb.services.CityPartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityPartsServiceImpl implements CityPartsService {
    private final CityPartsRepository cityPartsRepository;


    @Override
    public CityParts saveCityParts(CityParts cityParts) {
        return cityPartsRepository.save(cityParts);
    }
}
