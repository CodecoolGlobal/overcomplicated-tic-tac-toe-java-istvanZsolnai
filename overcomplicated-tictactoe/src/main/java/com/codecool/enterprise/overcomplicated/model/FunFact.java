package com.codecool.enterprise.overcomplicated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FunFact {

    @JsonProperty("value")
    private String value;

}
