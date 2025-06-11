package com.example.dev.offer.service;

import com.example.dev.offer.dto.OfferDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface OfferService {

    OfferDto getOfferById(String offerId);

    String createOffer(@RequestBody OfferDto offerRequestDto);

    OfferDto updateOffer(String offerId, @RequestBody OfferDto offerRequestDto);

    void deleteOffer(String offerId);
}
