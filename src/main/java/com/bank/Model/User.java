package com.bank.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(unique = true)
    private String username;
    @Column
    private Integer age;
    @Column
    private String cin;
    @Column
    private String genre;
    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Compte> comptes;


}
