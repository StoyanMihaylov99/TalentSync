package com.example.dev.review.model;

import com.example.dev.accounts.model.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;
    @Column(name = "rate", nullable = false, precision = 2, scale = 1)
    @Min(value = 1, message = "Rate must be between 1 and 5")
    @Max(value = 5, message = "Rate must be between 1 and 5")
    private int rate;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    private Account owner;

}
