package com.springframework.habtom.microservice.beerbrewery.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    @Null
    private UUID id;
    @NotBlank
    @Size(min=3, max =100)
    private String customerName;
    @Positive
    private Integer age;

    private BigDecimal salary;
}