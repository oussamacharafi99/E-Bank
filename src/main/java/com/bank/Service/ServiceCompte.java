package com.bank.Service;
import com.bank.Repository.RepositoryCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCompte {
    @Autowired
    RepositoryCompte repoCompte;

}
