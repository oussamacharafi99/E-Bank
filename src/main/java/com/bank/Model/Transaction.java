package com.bank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    @Column()
    private Integer id;

    @ManyToOne
    @Column()
    private Compte compte;

    @ManyToOne
    @JoinColumn()
    private Beneficier beneficier;

    @Column()
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    @Column()
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime transactionTimer;

    @Column()
    private Double montant;

    @Column()
    private String type_transaction;

    @Column()
    private String description_transaction;

    @Column
    private String bank_transaction;



}
