package com.bank.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beneficier {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String bank;
    private Integer Account_number;

    @OneToMany
    private List<Compte> compteList;
}
