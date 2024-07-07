package com.bank.Controller;

import com.bank.Model.Carte;
import com.bank.Service.ServiceCarte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/carte")
public class CarteController {

    @Autowired
    ServiceCarte serviceCarte;

    @GetMapping("/get/{compte_id}/{carte_id}")
    public Carte getCarte(@PathVariable("compte_id") Integer compte_id, @PathVariable("carte_id") Integer carte_id) {
        System.out.println("Id of compte: " + compte_id + " carte: " + carte_id);
        return serviceCarte.getCarte(carte_id, compte_id);
    }

    @PostMapping("/update/{id}")
    public Carte updateCarte(@PathVariable Integer id, @RequestBody Carte carte) {
        System.out.println("////////CCC///////////////////"+carte.getStatus()+"///////////"+id);
        return serviceCarte.UpdateStatusCarte(id,carte.getStatus());
    }

}
