package com.springframework.habtom.microservice.beerbrewery.web.controllers;

import com.springframework.habtom.microservice.beerbrewery.services.BeerService;
import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity saveBeer(@RequestBody BeerDTO beerDTO) {

        BeerDTO beer = beerService.save(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + beer.getBeerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO) {
        beerService.updateBeerDto(beerId, beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void handleDelete(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);


    }
}
