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
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Beneficier beneficier;

    @Column()
    private String type;

    @Column()
    private String solde;

    @Column()
    private Date date_creation;

    @Column()
    private Boolean status;

}
