package com.example.dev.offer.model;

import com.example.dev.accounts.model.Account;
import com.example.dev.utils.Currency;
import com.example.dev.utils.Tag;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.math.BigDecimal;
import java.util.List;

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
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters long")
    private String title;
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(name = "price", nullable = false, precision = 19, scale = 4)
    private BigDecimal price;
    @Column(name = "tags", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Tag> tags;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;
    @Column(name = "duration_in_minutes", nullable = false)
    @Min(value = 10, message = "Duration must be at least 10 minute")
    @Max(value = 3000, message = "Duration must not exceed 50 hours")
    private int durationInMinutes;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account owner;

}
