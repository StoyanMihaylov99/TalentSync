package com.example.dev.accounts.dto;

import com.example.dev.offer.model.Offer;
import com.example.dev.payment.model.Payment;
import com.example.dev.review.model.Review;
import com.example.dev.schedule.model.Schedule;
import com.example.dev.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String pictureUrl;
    private Role role;
    private String balance;
    private List<Offer> offers;
    private List<Schedule> schedules;
    private List<Review> reviews;
    private List<Payment> receivedPayments;
    private List<Payment> sentPayments;
    private LocalDate dateOfBirth;
}
