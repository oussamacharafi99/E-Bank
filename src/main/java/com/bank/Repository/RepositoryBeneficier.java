package com.bank.Repository;

import com.bank.Model.Beneficier;
import com.bank.Model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryBeneficier extends JpaRepository<Beneficier, Integer> {
    List<Beneficier> findBeneficiersByCompte_Id(int compte_id);
}
