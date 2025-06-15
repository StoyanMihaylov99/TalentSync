package com.example.dev.schedule.model;

import com.example.dev.offer.model.Offer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;

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

}
