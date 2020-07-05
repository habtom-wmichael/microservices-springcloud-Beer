package com.springframework.habtom.microservice.beerbrewery.web.controllers.v2;

import com.springframework.habtom.microservice.beerbrewery.services.BeerService;
import com.springframework.habtom.microservice.beerbrewery.services.v2.BeerServicev2;
import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;
import com.springframework.habtom.microservice.beerbrewery.web.models.v2.BeerDtov2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Validated
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerv2 {


    private BeerServicev2 beerServicev2;

    public BeerControllerv2(BeerServicev2 beerServicev2) {
        this.beerServicev2 = beerServicev2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtov2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity saveBeer(@Valid @RequestBody BeerDtov2 beerDtov2) {

        BeerDtov2 beer = beerServicev2.save(beerDtov2);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + beer.getBeerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@NotNull@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDtov2 beerDtov2) {
        beerServicev2.updateBeerDto(beerId, beerDtov2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void handleDelete(@NotNull @PathVariable("beerId") UUID beerId){
        beerServicev2.deleteById(beerId);


    }
    public ResponseEntity<List> validatiionErrorHandler(ConstraintViolationException e){

        List<String> errors= new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath()+" : "+constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

