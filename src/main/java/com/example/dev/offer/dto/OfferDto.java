package com.example.dev.offer.dto;

import com.example.dev.utils.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public record OfferDto(
        @JsonProperty(required = true)
        String id,
        @JsonProperty(required = true)
        String title,
        @JsonProperty(required = true)
        String description,
        @JsonProperty(required = true)
        BigDecimal price,
        @JsonProperty(required = true)
        List<Tag> tags,
        @JsonProperty(required = true)
        Currency currency,
        @JsonProperty(required = true)
        int durationInMinutes,
        @JsonProperty(required = true)
        String ownerId

) {
}
