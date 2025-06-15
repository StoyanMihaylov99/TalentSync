package com.example.dev.config;

import com.example.dev.accounts.dto.AccountDto;
import com.example.dev.accounts.model.Account;
import com.example.dev.offer.dto.OfferDto;
import com.example.dev.offer.model.Offer;
import com.example.dev.review.dto.ReviewDto;
import com.example.dev.review.model.Review;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // Skip id when mapping from AccountDto to Account
        mapper.createTypeMap(AccountDto.class, Account.class)
                .addMappings(mapping -> mapping.skip(Account::setId));

        // Skip id when mapping from OfferDto to Offer
        mapper.createTypeMap(OfferDto.class, Offer.class)
                .addMappings(mapping -> mapping.skip(Offer::setId));

        mapper.createTypeMap(ReviewDto.class, Review.class)
                .addMappings(mapping -> mapping.skip(Review::setId));

        return mapper;
    }
}
