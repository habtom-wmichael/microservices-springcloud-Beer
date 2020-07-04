package com.springframework.habtom.microservice.beerbrewery.services.v2;

import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;
import com.springframework.habtom.microservice.beerbrewery.web.models.v2.BeerDtov2;

import java.util.UUID;

public interface BeerServicev2 {
    BeerDtov2 getBeerById(UUID beerId);

    BeerDtov2 save(BeerDtov2 beerDtov2);

    void updateBeerDto(UUID beerId, BeerDtov2 beerDtov2);

    void deleteById(UUID beerId);
}
