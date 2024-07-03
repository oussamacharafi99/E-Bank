package com.bank.Service;
import com.bank.Repository.RepositoryBeneficier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBeneficier {
    @Autowired
    RepositoryBeneficier repoBeneficier;
}
