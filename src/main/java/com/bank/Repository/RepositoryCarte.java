package com.bank.Repository;
import com.bank.Model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCarte extends JpaRepository<Carte, Integer> {
    Carte findCarteByIdAndCompte_Id(int id, int compte_id);
}
