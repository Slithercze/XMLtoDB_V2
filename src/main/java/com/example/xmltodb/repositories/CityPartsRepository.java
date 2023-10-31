package com.example.xmltodb.repositories;

import com.example.xmltodb.models.CityParts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityPartsRepository extends CrudRepository<CityParts, Long> {
}
