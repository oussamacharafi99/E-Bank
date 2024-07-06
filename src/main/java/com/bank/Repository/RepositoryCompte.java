package com.bank.Repository;
import com.bank.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCompte extends JpaRepository<Compte, Integer> {

    @Query("select c.solde from Compte c where c.id=:id")
    Integer getSolde(@Param("id") Integer id);

//    List<Compte> findCompteByUserIdAndStatusTrueAndSoldeIsNotNullAndSoldeGreaterThanEqual
}
