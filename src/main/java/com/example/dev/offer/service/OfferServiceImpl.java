package com.example.dev.offer.service;

import com.example.dev.offer.dto.OfferDto;
import com.example.dev.offer.model.Offer;
import com.example.dev.offer.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<OfferDto> getOfferById(String offerId) {
        Optional<Offer> result = offerRepository.findById(offerId);
        if (result.isPresent()) {
            return Optional.of(modelMapper.map(result.get(), OfferDto.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> createOffer(OfferDto offerRequestDto) {
        Offer savedOffer = offerRepository.save(modelMapper.map(offerRequestDto, Offer.class));
        return Optional.of(savedOffer.getId());
    }

    @Override
    public Optional<OfferDto> updateOffer(String id,OfferDto offerRequestDto) {
        Optional<Offer> existingOffer = offerRepository.findById(id);
        if (existingOffer.isPresent()) {
            Offer newOfer = modelMapper.map(offerRequestDto, Offer.class);
            newOfer.setId(id);
            newOfer.setOwner(existingOffer.get().getOwner());
            return Optional.of(modelMapper.map(offerRepository.save(newOfer), OfferDto.class));
        }
        return Optional.empty();
    }

    @Override
    public void deleteOffer(String offerId) {
        offerRepository.deleteById(offerId);
    }

    @Override
    public Optional<List<OfferDto>> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        if (offers.isEmpty()) {
            return Optional.empty();
        }
        List<OfferDto> offerDtos = offers.stream()
                .map(offer -> modelMapper.map(offer, OfferDto.class))
                .toList();
        return Optional.of(offerDtos);
    }
}
