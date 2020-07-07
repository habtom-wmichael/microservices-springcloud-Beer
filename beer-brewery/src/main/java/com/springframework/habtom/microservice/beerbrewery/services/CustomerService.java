package com.springframework.habtom.microservice.beerbrewery.services;


import com.springframework.habtom.microservice.beerbrewery.web.models.CustomerDto;

import java.util.UUID;

public interface CustomerService {
  public CustomerDto getCustomerById(UUID customerId);

  CustomerDto save(CustomerDto customerDto);

  void updateCustmer(UUID customerId, CustomerDto customerDto);

  void deleteCustmer(UUID customerId);
}
