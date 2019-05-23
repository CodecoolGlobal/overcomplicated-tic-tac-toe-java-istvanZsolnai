package com.codecool.enterprise.overcomplicated.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class FunFact {

    @JsonProperty("category")
    private String category;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("value")
    private String value;

}
