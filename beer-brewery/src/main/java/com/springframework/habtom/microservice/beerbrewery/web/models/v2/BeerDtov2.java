package com.springframework.habtom.microservice.beerbrewery.web.models.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtov2 {
    @NotNull
    private UUID beerId;
    @NotBlank
    @Size(min = 3, max = 30)
    private String beerName;
    private BeerStyleEnum beerStyle;
    @Positive
    private Long upc;
}
