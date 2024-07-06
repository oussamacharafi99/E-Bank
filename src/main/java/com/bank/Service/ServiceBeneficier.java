package com.bank.Service;
import com.bank.Model.Beneficier;
import com.bank.Model.Carte;
import com.bank.Repository.RepositoryBeneficier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBeneficier {
    @Autowired
    RepositoryBeneficier repoBeneficier;

    public Beneficier addBeneficier(Beneficier beneficier) {
        return repoBeneficier.save(beneficier);
    }

    public void RemoveBeneficier(Integer id) {
         repoBeneficier.deleteById(id);
    }

    public Beneficier GetBeneficierById(Integer id) {
        return repoBeneficier.findById(id).orElseThrow();
    }

    public List<Beneficier> GetBeneficiers(Integer id) {
        return repoBeneficier.findBeneficiersByCompte_Id(id);
    }

    public Beneficier updateBeneficier(Integer id , Beneficier beneficier) {
       Beneficier beneficier1 = repoBeneficier.findById(id).orElseThrow();
       beneficier1.setUsername(beneficier.getUsername());
       beneficier1.setBank(beneficier.getBank());
       beneficier1.setAccount_number(beneficier.getAccount_number());
       beneficier1.setCompte(beneficier.getCompte());
        return repoBeneficier.save(beneficier1);
    }
}

