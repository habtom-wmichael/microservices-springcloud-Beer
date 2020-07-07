package com.springframework.habtom.microservice.beerbrewery.web.controllers;


import com.springframework.habtom.microservice.beerbrewery.services.CustomerService;
import com.springframework.habtom.microservice.beerbrewery.web.models.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/app/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustmoer(@NotNull @PathVariable("customerId") UUID customerId) {

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveNewCustmoer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerService.save(customerDto);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@NotNull @PathVariable("customerId") UUID customerId,@Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustmer(customerId, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity handleDelete(@NotNull @PathVariable("customerId") UUID customerId) {
        customerService.deleteCustmer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandller(ConstraintViolationException e){
//        List<String> errors= new ArrayList<>(e.getConstraintViolations().size());
//
//        e.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath()+"  :  "+constraintViolation.getMessage());
//        });
//      return new ResponseEntity(errors,HttpStatus.BAD_REQUEST)  ;
//    }
}
