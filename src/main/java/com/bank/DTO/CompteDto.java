package com.bank.DTO;
import com.bank.Enums.CompteType;
import com.bank.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompteDto {

    private Integer id;

    private String accountNumber;

    private CompteType type;

    private Double solde;

    private LocalDate date_creation;

    private Boolean status;

    private Integer id_user;

}
