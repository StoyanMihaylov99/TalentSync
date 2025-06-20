package com.example.dev.offer.controller;

import com.example.dev.offer.dto.CreateOfferResponseDto;
import com.example.dev.offer.dto.OfferDto;
import com.example.dev.offer.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CreateOfferResponseDto> createOffer(@RequestBody OfferDto offerDto) {
        Optional<CreateOfferResponseDto> response = offerService.createOffer(offerDto);
        if (response.isPresent()) {
            return ResponseEntity.status(201).body(response.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{offerId}")
    public ResponseEntity<OfferDto> getOfferById(@PathVariable String offerId) {
        return offerService.getOfferById(offerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OfferDto>> getAllOffers() {
        return offerService.getAllOffers()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("/{offerId}")
    public ResponseEntity<OfferDto> updateOffer(@PathVariable String offerId, @RequestBody OfferDto offerDto) {
        OfferDto updatedOffer = modelMapper.map(offerDto, OfferDto.class);
        return offerService.updateOffer(offerId,updatedOffer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{offerId}")
    public ResponseEntity<Void> deleteOffer(@PathVariable String offerId) {
        offerService.deleteOffer(offerId);
        return ResponseEntity.noContent().build();
    }
}
