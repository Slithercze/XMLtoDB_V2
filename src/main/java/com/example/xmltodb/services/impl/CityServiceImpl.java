package com.example.xmltodb.services.impl;

import com.example.xmltodb.models.City;
import com.example.xmltodb.repositories.CityRepository;
import com.example.xmltodb.services.CityService;

import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;


    @Override
    public City saveCities(City city) {
       return cityRepository.save(city);
    }

    @Override
    public Iterable<City> getCities() {
        return cityRepository.findAll();
    }
}
