package com.springframework.habtom.microservice.beerbrewery.web.mapper;

import com.springframework.habtom.microservice.beerbrewery.domain.Beer;
import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDTO beerDtoToBeer(Beer beer);
    Beer beerToBeerDto(BeerDTO beerDTO);
}
