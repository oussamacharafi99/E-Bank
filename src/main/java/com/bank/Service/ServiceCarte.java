package com.bank.Service;
import com.bank.Enums.CarteStatus;
import com.bank.Model.Carte;
import com.bank.Repository.RepositoryCarte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCarte {
    @Autowired
    RepositoryCarte repoCarte;

    public Carte getCarte(Integer Carte_id, Integer Compte_id){
        return repoCarte.findCarteByIdAndCompte_Id(Carte_id, Compte_id);
    }

    public Carte UpdateStatusCarte(Integer carte_id, CarteStatus status){


        Carte carte = repoCarte.findById(carte_id).orElseThrow();
        carte.setStatus(status);
        return repoCarte.save(carte);
    }
}
