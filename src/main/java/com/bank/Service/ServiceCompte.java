package com.bank.Service;
import com.bank.DTO.CompteDto;
import com.bank.Enums.CarteStatus;
import com.bank.Enums.CarteType;
import com.bank.Model.Carte;
import com.bank.Model.Compte;
import com.bank.Repository.RepositoryCarte;
import com.bank.Repository.RepositoryCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.Exeptions.AppExeption;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ServiceCompte {
    @Autowired
    RepositoryCompte repoCompte;

    @Autowired
    private RepositoryCarte repoCarte;

    public List<CompteDto> getComptesById(Integer id){
//            repoCompte.findComptesByUser_Id(id).stream()
//                    .filter( compte -> compte.getStatus()
//                            .equals(true)).toList();
            List<CompteDto> compteDtoList = new ArrayList<>();
            CompteDto compteDto = new CompteDto();
            for(Compte c : repoCompte.findComptesByUser_Id(id)) {
                if (c.getStatus().equals(true)) {
                    compteDto.setId(c.getId());
                    compteDto.setAccountNumber(c.getAccountNumber());
                    compteDto.setSolde(c.getSolde());
                    compteDto.setStatus(c.getStatus());
                    compteDto.setType(c.getType());
                    compteDto.setDate_creation(c.getDate_creation());
                    compteDto.setId_user(c.getUser().getId());

                    System.out.println("User id " + compteDto.getId_user());
                    compteDtoList.add(compteDto);
                }
            }
            return compteDtoList;
    }

    public Integer getSoldeById(Integer id){
        return repoCompte.getSolde(id);
    }

    public Compte getCompteById(int id){
        return repoCompte.getById(id);
    }

    public void deleteCompteById(Integer id){
        repoCompte.deleteById(id);
    }

    @Transactional
    public String closeCompte(Integer id){
        Compte compteUp = getCompteById(id);
        if (compteUp.getSolde() >= 0 ){
            compteUp.setStatus(false);
            List<Carte> cartes = repoCarte.findCartesByCompte_Id(compteUp.getId());
            cartes.forEach(carte -> carte.setStatus(CarteStatus.blocked));
            repoCompte.save(compteUp);
            return "The account has been closed";
        }
        else {
            compteUp.setStatus(true);
            repoCompte.save(compteUp);
            return "The account has not been closed because you have (-) in your account";
        }
    }

    public Compte createCompte(Compte compte) {
        compte.setStatus(true);
        compte.setAccountNumber(generateCarteNumero());
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
