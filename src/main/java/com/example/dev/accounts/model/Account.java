package com.example.dev.accounts.model;

import com.example.dev.offer.model.Offer;
import com.example.dev.payment.model.Payment;
import com.example.dev.review.model.Review;
import com.example.dev.schedule.model.Schedule;
import com.example.dev.utils.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;
    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters long")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters long")
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
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
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
