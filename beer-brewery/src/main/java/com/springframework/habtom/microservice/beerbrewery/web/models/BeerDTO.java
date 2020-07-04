package com.springframework.habtom.microservice.beerbrewery.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {
    private UUID beerId;
    private String beerName;
    private String beerStyle;
    private Long upc;
}
