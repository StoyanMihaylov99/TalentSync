package com.example.dev.offer.repository;

import com.example.dev.offer.model.Offer;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

    @NonNull
    Optional<Offer> findByTitle(@NonNull String title);

    void deleteById(@NonNull String id);

}
