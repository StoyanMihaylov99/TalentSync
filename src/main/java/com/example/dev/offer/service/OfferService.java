package com.example.dev.offer.service;

import com.example.dev.offer.dto.OfferDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    Optional<OfferDto> getOfferById(String offerId);

    Optional<String> createOffer(@RequestBody OfferDto offerRequestDto);

    Optional<OfferDto> updateOffer(@RequestBody OfferDto offerRequestDto);

    void deleteOffer(String offerId);

    Optional<List<OfferDto>> getAllOffers();
}
