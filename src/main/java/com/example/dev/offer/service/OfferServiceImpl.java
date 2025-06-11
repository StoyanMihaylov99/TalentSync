package com.example.dev.offer.service;

import com.example.dev.offer.dto.OfferDto;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    @Override
    public OfferDto getOfferById(String offerId) {
        return null;
    }

    @Override
    public String createOffer(OfferDto offerRequestDto) {
        return "";
    }

    @Override
    public OfferDto updateOffer(String offerId, OfferDto offerRequestDto) {
        return null;
    }

    @Override
    public void deleteOffer(String offerId) {
        // Implementation for deleting an offer
    }
}
