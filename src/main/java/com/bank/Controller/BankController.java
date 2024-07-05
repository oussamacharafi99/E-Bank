package com.bank.Controller;
import com.bank.Model.Beneficier;
import com.bank.Model.Compte;
import com.bank.Model.User;
import com.bank.Service.ServiceBeneficier;
import com.bank.Service.ServiceCompte;
import com.bank.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BankController {

    @Autowired
    ServiceUser serviceUser;
    @Autowired
    ServiceCompte serviceCompte;
    @Autowired
    ServiceBeneficier serviceBeneficier;

    @GetMapping("/user")
    public User getUser() {
        return serviceUser.getUser(1);
    }


    /**********************- Account Section -***********************/

    @PostMapping("/add_compte")
    public Compte addCompte(@RequestBody Compte compte) {
        return serviceCompte.createCompte(compte);
    }

    @GetMapping("/delete_compte/{id}")
    public void deleteCompte(@PathVariable Integer id) {
         serviceCompte.deleteCompteById(id);
    }

    @GetMapping("/get_all_comptes")
    public List<Compte> getAllComptes() {
        return serviceCompte.getComptes();
    }


    @PutMapping("/compte/status/{id}")
    public Compte closeCompte(@PathVariable Integer id){
        return serviceCompte.closeCompte(id);
    }



    /**********************- Beneficier Section -***********************/

    @PostMapping("/addbeneficier")
    public Beneficier addBeneficier(@RequestBody Beneficier beneficier){
        return serviceBeneficier.addBeneficier(beneficier);
    }

}
