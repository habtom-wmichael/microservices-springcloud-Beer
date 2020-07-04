package com.springframework.habtom.microservice.beerbrewery.services.serviceImpl.v2;

import com.springframework.habtom.microservice.beerbrewery.services.v2.BeerServicev2;
import com.springframework.habtom.microservice.beerbrewery.web.models.v2.BeerDtov2;
import com.springframework.habtom.microservice.beerbrewery.web.models.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplv2 implements BeerServicev2 {

    @Override
    public BeerDtov2 getBeerById(UUID beerId) {
        return BeerDtov2.builder()
                .beerId(UUID.randomUUID())
                .beerName("Heinken ")
                .beerStyle(BeerStyleEnum.LAGER)
                .build();
    }

    @Override
    public BeerDtov2 save(BeerDtov2 beerDtov2) {
        return BeerDtov2.builder()
                .beerId(UUID.randomUUID())
                .beerName("Corena")
                .beerStyle(BeerStyleEnum.GOSE)
                .build();
    }

    @Override
    public void updateBeerDto(UUID beerId, BeerDtov2 beerDtov2) {
//
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("debugging.........");
    }
}
