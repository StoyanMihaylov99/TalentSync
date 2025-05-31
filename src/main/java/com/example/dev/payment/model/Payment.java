package com.example.dev.payment.model;
import com.example.dev.accounts.model.Account;
import com.example.dev.utils.Currency;
import jakarta.persistence.*;
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
    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;
    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account sender;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account receiver;
    @Column(name = "fee_rate", nullable = false, precision = 4, scale = 2)
    private BigDecimal feeRate;

}
