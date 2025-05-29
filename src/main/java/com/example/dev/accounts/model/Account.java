package com.example.dev.accounts.model;

import com.example.dev.offer.model.Offer;
import com.example.dev.payment.model.Payment;
import com.example.dev.schedule.model.Schedule;
import com.example.dev.utils.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
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
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany
    private List<Offer> offers;
    @OneToMany
    private List<Schedule> schedules;
    @OneToMany
    private List<Payment> payments;
}
