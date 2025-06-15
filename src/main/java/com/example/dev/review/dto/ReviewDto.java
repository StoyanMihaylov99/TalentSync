package com.example.dev.review.dto;

import com.example.dev.accounts.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto {

    private String id;
    private int rate;
    private String description;
    private Account reviewer;
}
