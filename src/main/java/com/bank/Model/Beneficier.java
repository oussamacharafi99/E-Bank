package com.bank.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beneficier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String bank;

    @Column
    private String account_number;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    public Beneficier(String username, String bank, String account_number, Compte compte) {
        this.username = username;
        this.bank = bank;
        this.account_number = account_number;
        this.compte = compte;
    }
}
