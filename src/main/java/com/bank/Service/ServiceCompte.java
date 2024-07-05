package com.bank.Service;
import com.bank.Enums.CarteStatus;
import com.bank.Enums.CarteType;
import com.bank.Model.Carte;
import com.bank.Model.Compte;
import com.bank.Repository.RepositoryCarte;
import com.bank.Repository.RepositoryCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ServiceCompte {
    @Autowired
    RepositoryCompte repoCompte;

    @Autowired
    private RepositoryCarte repoCarte;

    public List<Compte> getComptes(){
        return repoCompte.findAll().stream().filter(compte -> compte.getStatus().equals(true)).toList();
    }

    public Compte getCompteById(int id){
        return repoCompte.getById(id);
    }

    public void deleteCompteById(Integer id){
        repoCompte.deleteById(id);
    }

    public Compte closeCompte(Integer id){
        Compte compteUp=getCompteById(id);
        compteUp.setStatus(false);
        return repoCompte.save(compteUp);
    }

    public Compte createCompte(Compte compte) {
        compte.setStatus(true);
        Compte savedCompte = repoCompte.save(compte);
        createCarte(savedCompte);
        return savedCompte;
    }

    private void createCarte(Compte compte) {
        Carte carte = new Carte();
        carte.setCarte_numero(generateCarteNumero());
        carte.setDate_expiration(generateDateExpiration());
        carte.setCarte_type(CarteType.debit);
        carte.setStatus(CarteStatus.actived);
        carte.setCompte(compte);
        repoCarte.save(carte);
    }
    private String generateCarteNumero() {
        Random random = new Random();
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            numero.append(digit);
        }
        return numero.toString();
    }

    private Date generateDateExpiration() {
        LocalDate now = LocalDate.now();
        LocalDate expirationDate = now.plusYears(3);
        return java.sql.Date.valueOf(expirationDate);
    }
}
