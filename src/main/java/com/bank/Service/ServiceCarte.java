package com.bank.Service;
import com.bank.Repository.RepositoryCarte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCarte {
    @Autowired
    RepositoryCarte repoCarte;
}
