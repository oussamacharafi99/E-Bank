package com.bank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private Integer carte_numero;

    @Column
    private Date date_expiration;

    @Column
    private String carte_type;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;



}
