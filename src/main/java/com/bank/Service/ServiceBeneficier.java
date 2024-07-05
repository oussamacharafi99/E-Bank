package com.bank.Service;
import com.bank.Model.Beneficier;
import com.bank.Model.Carte;
import com.bank.Repository.RepositoryBeneficier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Beneficier GetBeneficier(Integer id) {
        return repoBeneficier.findById(id).orElseThrow();
    }

    public Beneficier updateBeneficier(Integer id , Beneficier beneficier) {
        return repoBeneficier.save(beneficier);
    }
}

