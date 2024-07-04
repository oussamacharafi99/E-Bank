package com.bank.Service;
import com.bank.Model.Compte;
import com.bank.Repository.RepositoryCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCompte {
    @Autowired
    RepositoryCompte repoCompte;
    public Compte saveCompte(Compte compte){
        return repoCompte.save(compte);
    }
    public List<Compte> getComptes(){
        return repoCompte.findAll();
    }
    public Compte getCompteById(int id){
        return repoCompte.getById(id);
    }
}
