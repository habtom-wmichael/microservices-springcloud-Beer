package com.springframework.habtom.microservice.beerbrewery.services.serviceImpl;


import com.springframework.habtom.microservice.beerbrewery.services.CustomerService;
import com.springframework.habtom.microservice.beerbrewery.web.models.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Habtom")
                .age(29)
                .salary(new BigDecimal(100000.00))
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Ydaiel")
                .age(7)
                .salary(new BigDecimal(1000.00))
                .build();

    }

    @Override
    public void updateCustmer(UUID customerId, CustomerDto customerDto) {
//impl updating
    }

    @Override
    public void deleteCustmer(UUID customerId) {
//do impl
        log.debug("deleting a customer");
    }


}
