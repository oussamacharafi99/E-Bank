package com.bank.Repository;

import com.bank.Model.Beneficier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBeneficier extends JpaRepository<Beneficier, Integer> {
}
