package com.bank.Model;

import com.bank.Enums.CarteStatus;
import com.bank.Enums.CarteType;
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
    private String carte_numero;

    @Column
    private Date date_expiration;

    @Column
    @Enumerated(EnumType.STRING)
    private CarteType carte_type;

    @Column
    @Enumerated(EnumType.STRING)
    private CarteStatus status;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;


}
