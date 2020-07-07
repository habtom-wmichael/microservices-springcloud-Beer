package com.springframework.habtom.microservice.beerbrewery.web.mapper;

import com.springframework.habtom.microservice.beerbrewery.domain.Customer;
import com.springframework.habtom.microservice.beerbrewery.web.models.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerDtoToCustomer(Customer customer);
    Customer customerToCustomerDto(CustomerDto customerDto);
}
