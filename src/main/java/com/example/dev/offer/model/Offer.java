package com.example.dev.offer.model;

import com.example.dev.accounts.model.Account;
import com.example.dev.utils.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "tags", nullable = false)
    private Tag tags;
    @Column(name = "duration_in_hours", nullable = false)
    private double durationInHours;
    @OneToOne
    private Account owner;

}
