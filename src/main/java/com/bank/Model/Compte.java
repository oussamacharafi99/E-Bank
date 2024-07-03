package com.bank.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private String type;

    @Column()
    private String solde;

    @Column()
    private Date date_creation;

    @Column()
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "compte")
    List<Beneficier> listOfBeneficier;

    @OneToMany(mappedBy = "compte")
    List<Transaction> listOfTransactions;

    @OneToMany(mappedBy = "compte")
    List<Carte> listOfCarte;

}
