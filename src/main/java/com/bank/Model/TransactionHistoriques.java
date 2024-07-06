package com.bank.Model;

import com.bank.Enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionHistoriques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer id;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    @Column
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime transactionTimer;

    @Column()
    private Double montant;

    @Column()
    private TransactionType type_transaction;

    @Column()
    private String description_transaction;

    @Column
    private String bank_transaction;

    @ManyToOne
    @JoinColumn
    private Compte compte;

    @ManyToOne
    @JoinColumn
    private Beneficier beneficier;
}
