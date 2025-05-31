package com.example.dev.schedule.model;

import com.example.dev.accounts.model.Account;
import com.example.dev.offer.model.Offer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;
    @Column(name = "starting_dateTime", nullable = false)
    private LocalDateTime startingDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private Offer lessionOffer;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Account> participants;

}
