package com.bank;

import com.bank.Model.Compte;
import com.bank.Model.User;
import com.bank.Service.ServiceCompte;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.ServiceConfigurationError;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	ServiceCompte serviceCompte;

//	@Test
//	void savecompteTest() {
//		User user = new User();
//		user.setId(1);
//		Compte compte = new Compte("se", 12, LocalDate.now(), user);
//		assertEquals(new Compte(), );
//	}


//	@Test
//	void Test() {
//		Integer a=7;
//		Integer b=8;
//		assertEquals(15,a+b);
//
//	}


}
