package com.bank.Controller;

import com.bank.Model.Beneficier;
import com.bank.Service.ServiceBeneficier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiers")
public class BeneficierController {

    @Autowired
    ServiceBeneficier serviceBeneficier;

    /**********************- Beneficier Section -***********************/

    @PostMapping("/add")
    public Beneficier addBeneficier(@RequestBody Beneficier beneficier) {
        return serviceBeneficier.addBeneficier(beneficier);
    }

    @GetMapping("/get/{id}")
    public List<Beneficier> getBeneficier(@PathVariable Integer id){
        return serviceBeneficier.GetBeneficiers(id);
    }
    @PutMapping("/update/{id}")
    public Beneficier updateBeneficier(@RequestBody Beneficier beneficier ,@PathVariable Integer id){
        return serviceBeneficier.updateBeneficier(id, beneficier);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBeneficier(@PathVariable("id") Integer id){
         serviceBeneficier.RemoveBeneficier(id);
    }

}
