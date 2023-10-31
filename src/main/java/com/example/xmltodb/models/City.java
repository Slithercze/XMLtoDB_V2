package com.example.xmltodb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class City {
    @Id
    @Column(name = "city_id")
    private Long id;
    private String name;

    @JsonIgnoreProperties("city")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_city_id", referencedColumnName = "city_id")
    private List<CityParts> cityParts;
}
