package com.bank;

import com.bank.Enums.TransactionType;
import com.bank.Model.Beneficier;
import com.bank.Model.Compte;
import com.bank.Model.Transaction;
import com.bank.Service.ServiceBeneficier;
import com.bank.Service.ServiceCompte;
import com.bank.Service.ServiceTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankApplicationTests {

//	@Autowired
//	ServiceCompte serviceCompte;
//
//	@Autowired
//	ServiceTransaction serviceTransaction;
//	@Autowired
//	ServiceBeneficier serviceBeneficier;
//
//	@Test
//	@Transactional
//	void testCreateCompte() {
//		Compte compte = new Compte();
//		compte.setSolde(1000.0);
//
//		Compte savedCompte = serviceCompte.createCompte(compte);
//		assertNotNull(savedCompte);
//		assertEquals(1000, savedCompte.getSolde());
//		assertNotNull(savedCompte.getAccountNumber());
//	}
//
//	@Test
//	@Transactional
//	void testCloseCompte() {
//		Compte compte = new Compte();
//		compte.setSolde(500.0);
//
//		Compte savedCompte = serviceCompte.createCompte(compte);
//		String result = serviceCompte.closeCompte(savedCompte.getId());
//
//		assertEquals("The account has been closed", result);
//		assertFalse(savedCompte.getStatus());
//	}
//
//	@Test
//	@Transactional
//	void testGetSoldeById() {
//		Compte compte = new Compte();
//		compte.setSolde(1500.0);
//
//		Compte savedCompte = serviceCompte.createCompte(compte);
//		Integer solde = serviceCompte.getSoldeById(savedCompte.getId());
//
//		assertEquals(1500, solde);
//	}
//
//	@Test
//	void testValidationDeTransaction(){
//		Compte compte = serviceCompte.getCompteById(1);
//		Beneficier beneficier=serviceBeneficier.GetBeneficierById(1);
//		Transaction transaction = new Transaction(valueOf(LocalDate.now()),LocalTime.now(),10000.0,TransactionType.credit,"debit","cih",compte,beneficier);
//		String response=serviceTransaction.CreateTransaction(1 , transaction);
//		assertEquals("Le solde du compte est insuffisant ou null",response);
//
//	}
//

}
