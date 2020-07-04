package com.springframework.habtom.microservice.beerbrewery.services;

import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;

import java.util.UUID;

public interface BeerService {
   public BeerDTO getBeerById(UUID beerId);

  public   BeerDTO save(BeerDTO beerDTO);

   public void updateBeerDto(UUID beerId, BeerDTO beerDTO);

  public void deleteById(UUID beerId);
}
