package com.duoc.deepwallet.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValorDolarDto {

    @JsonProperty("CLP")
    @JsonAlias("ultimoCierre")
    private float ultimoCierre;
}