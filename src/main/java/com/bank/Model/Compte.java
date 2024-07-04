package com.bank.Model;
import com.bank.Enums.CompteType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    private CompteType type;

    @Column()
    private Integer solde;

    @Column()
    private LocalDate date_creation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "compte")
    @JsonIgnore
    List<Beneficier> listOfBeneficier;

    @OneToMany(mappedBy = "compte")
    @JsonIgnore
    List<Transaction> listOfTransactions;

    @OneToMany(mappedBy = "compte")
    @JsonIgnore
    List<Carte> listOfCarte;

    public Compte(CompteType type, Integer solde, LocalDate date_creation, User user) {
        this.type = type;
        this.solde = solde;
        this.date_creation = date_creation;
        this.user = user;
    }
}
