package com.codecool.enterprise.overcomplicated.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class Recommendation {

    @JsonProperty("recommendation")
    private String recommendation;
}
