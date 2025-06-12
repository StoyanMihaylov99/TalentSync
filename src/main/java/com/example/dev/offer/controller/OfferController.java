package com.example.dev.offer.controller;

import com.example.dev.offer.dto.OfferDto;
import com.example.dev.offer.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    public ResponseEntity<String> createOffer(@RequestBody OfferDto offerDto) {
        String id = offerService.createOffer(offerDto).toString();
        return ResponseEntity.status(201).body(id);
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
        return offerService.updateOffer(updatedOffer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{offerId}")
    public ResponseEntity<Void> deleteOffer(@PathVariable String offerId) {
        offerService.deleteOffer(offerId);
        return ResponseEntity.noContent().build();
    }

}
