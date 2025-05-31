package com.example.dev.accounts.model;

import com.example.dev.offer.model.Offer;
import com.example.dev.payment.model.Payment;
import com.example.dev.review.model.Review;
import com.example.dev.schedule.model.Schedule;
import com.example.dev.utils.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "accounts")
public final class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;
    @Column(name = "first_name", nullable = false)
    @Min(value = 2, message = "First name must be at least 2 characters long")
    @Max(value = 20, message = "First name must not exceed 50 characters")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @Min(value = 2, message = "Last name must be at least 2 characters long")
    @Max(value = 20, message = "Last name must not exceed 50 characters")
    private String lastName;
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal balance;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Offer> offers;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "reviewer", fetch = FetchType.LAZY)
    private List<Review> reviews;
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private List<Payment> receivedPayments;
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Payment> sentPayments;

}
