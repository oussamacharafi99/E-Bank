package com.bank.Model;

import jakarta.persistence.*;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private Integer age;
    @Column
    private Integer cin;
    @Column
    private String genre;
    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Compte> comptes;


}
