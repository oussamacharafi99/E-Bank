package com.bank.Controller;
import com.bank.Model.Compte;
import com.bank.Model.User;
import com.bank.Service.ServiceCompte;
import com.bank.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BankController {

    @Autowired
    ServiceUser serviceUser;
    @Autowired
    ServiceCompte serviceCompte;

    @GetMapping("/user")
    public User getUser() {
        return serviceUser.getUser(1);
    }


    /**********************- Account Section -***********************/

    @PostMapping("/addcompte")
    public Compte addCompte(@RequestBody Compte compte) {
        return serviceCompte.createCompte(compte);
    }
    @GetMapping("/deletecompte/{id}")
    public void deleteCompte(@PathVariable Integer id) {
         serviceCompte.deleteCompteById(id);
    }
    

    /**********************- Beneficier Section -***********************/

    @PostMapping("/deletebeneficier")
    public Compte addBeneficier(@RequestBody Compte compte) {
        return null;
    }
    @GetMapping("/deletebeneficier/{id}")
    public void deleteBeneficier(@PathVariable Integer id) {
        serviceCompte.deleteCompteById(id);
    }

}
