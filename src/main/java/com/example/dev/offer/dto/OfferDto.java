package com.example.dev.offer.dto;

import com.example.dev.utils.Currency;
import com.example.dev.utils.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {

    private String id;
    @JsonProperty(required = true)
    private String title;
    @JsonProperty(required = true)
    String description;
    @JsonProperty(required = true)
    BigDecimal price;
    @JsonProperty(required = true)
    List<Tag> tags;
    @JsonProperty(required = true)
    Currency currency;
    @JsonProperty(required = true)
    int durationInMinutes;
    @JsonProperty(required = true)
    String ownerId;
}
