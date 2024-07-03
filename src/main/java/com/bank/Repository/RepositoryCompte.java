package com.bank.Repository;
import com.bank.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCompte extends JpaRepository<Compte, Integer> {
}
