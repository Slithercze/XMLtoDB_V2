package com.example.xmltodb.services;

import com.example.xmltodb.models.City;

public interface CityService {
    City saveCities(City city);
    Iterable<City> getCities();
}
