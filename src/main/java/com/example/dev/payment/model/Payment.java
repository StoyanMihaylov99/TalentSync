package com.example.dev.payment.model;

import com.example.dev.utils.Currency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private String id;
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "currency", nullable = false)
    private Currency currency;
    @Column(name = "sender_id", nullable = false)
    private String senderId;
    @Column(name = "receiver_id", nullable = false)
    private String receiverId;
    @Column(name = "fee_rate", nullable = false)
    private double feeRate;
}
