package com.bank;

import com.bank.Model.Compte;
import com.bank.Service.ServiceCompte;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	ServiceCompte serviceCompte;

	@Test
	@Transactional
	void testCreateCompte() {
		Compte compte = new Compte();
		compte.setSolde(1000.0);

		Compte savedCompte = serviceCompte.createCompte(compte);
		assertNotNull(savedCompte);
		assertEquals(1000, savedCompte.getSolde());
		assertNotNull(savedCompte.getAccountNumber());
	}

	@Test
	@Transactional
	void testCloseCompte() {
		Compte compte = new Compte();
		compte.setSolde(500.0);

		Compte savedCompte = serviceCompte.createCompte(compte);
		String result = serviceCompte.closeCompte(savedCompte.getId());

		assertEquals("The account has been closed", result);
		assertFalse(savedCompte.getStatus());
	}

	@Test
	@Transactional
	void testGetSoldeById() {
		Compte compte = new Compte();
		compte.setSolde(1500.0);

		Compte savedCompte = serviceCompte.createCompte(compte);
		Integer solde = serviceCompte.getSoldeById(savedCompte.getId());

		assertEquals(1500, solde);
	}

	
}
