package com.springframework.habtom.microservice.beerbrewery.services.serviceImpl;

import com.springframework.habtom.microservice.beerbrewery.services.BeerService;
import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .beerId(UUID.randomUUID())
                .beerName("Heiken ")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO save(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .beerId(UUID.randomUUID())
                .beerName("Corena")
                .build();
    }

    @Override
    public void updateBeerDto(UUID beerId, BeerDTO beerDTO) {
        //do  update implementations
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting Beer...");
    }
}
