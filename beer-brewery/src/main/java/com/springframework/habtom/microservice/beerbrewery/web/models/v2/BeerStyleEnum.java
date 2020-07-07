package com.springframework.habtom.microservice.beerbrewery.web.models.v2;

public enum BeerStyleEnum {
    LAGER, PISLESNER,ALE,STOUT,GOSE,IPA;
    String style;

    BeerStyleEnum(String style) {
        this.style = style;
    }

    BeerStyleEnum() {

    }

    public String getStyle() {
        return style;
    }
}
