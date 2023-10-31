package com.example.xmltodb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CityParts {
    @Id
    @Column(name = "cityParts_id")
    private Long id;
    private String name;

    @JsonIgnoreProperties("cityParts")
    @ManyToOne
    @JoinColumn(name = "fk_city_id")
    private City city;
}
