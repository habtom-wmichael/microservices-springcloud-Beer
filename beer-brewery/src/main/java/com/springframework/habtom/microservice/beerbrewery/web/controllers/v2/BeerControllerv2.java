package com.springframework.habtom.microservice.beerbrewery.web.controllers.v2;

import com.springframework.habtom.microservice.beerbrewery.services.BeerService;
import com.springframework.habtom.microservice.beerbrewery.services.v2.BeerServicev2;
import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;
import com.springframework.habtom.microservice.beerbrewery.web.models.v2.BeerDtov2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerv2 {


    private BeerServicev2 beerServicev2;

    public BeerControllerv2(BeerServicev2 beerServicev2) {
        this.beerServicev2 = beerServicev2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtov2> getBeer(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity saveBeer(@RequestBody BeerDtov2 beerDtov2) {

        BeerDtov2 beer = beerServicev2.save(beerDtov2);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + beer.getBeerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtov2 beerDtov2) {
        beerServicev2.updateBeerDto(beerId, beerDtov2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void handleDelete(@PathVariable("beerId") UUID beerId){
        beerServicev2.deleteById(beerId);


    }
}

