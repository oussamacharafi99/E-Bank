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
public class Transaction {
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
    @Enumerated(EnumType.STRING)
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

    public Transaction(Date transactionDate, LocalTime transactionTimer, Double montant, TransactionType type_transaction, String description_transaction, String bank_transaction, Compte compte, Beneficier beneficier) {
        this.transactionDate = transactionDate;
        this.transactionTimer = transactionTimer;
        this.montant = montant;
        this.type_transaction = type_transaction;
        this.description_transaction = description_transaction;
        this.bank_transaction = bank_transaction;
        this.compte = compte;
        this.beneficier = beneficier;
    }
}
