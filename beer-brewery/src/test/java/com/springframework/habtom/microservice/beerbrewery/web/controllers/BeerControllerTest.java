package com.springframework.habtom.microservice.beerbrewery.web.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.springframework.habtom.microservice.beerbrewery.services.BeerService;
import com.springframework.habtom.microservice.beerbrewery.web.models.BeerDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BeerService beerService;
    private BeerDTO validBeer;

    @Before
    public void setUp() throws Exception {
validBeer=BeerDTO.builder()
        .beerId(UUID.randomUUID())
        .beerName("New Beer")
        .beerStyle("Pale Style")
        .upc(5648573473L)
        .build();

    }

    @Test
    public void getBeer() throws Exception {
        //geven
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
        mockMvc.perform(get("/api/v1/beer/" + validBeer.getBeerId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validBeer.getBeerId().toString())))
                .andExpect(jsonPath("$.beerName", is("New Beer")));



    }

    @Test
    public void saveBeer() {

    }

    @Test
    public void handleUpdate() {


    }
}
